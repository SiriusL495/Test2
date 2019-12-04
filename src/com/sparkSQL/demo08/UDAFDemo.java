package com.sparkSQL.demo08;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.expressions.UserDefinedAggregateFunction;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UDAFDemo {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("UDAFDemo")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> parallelize = sc.parallelize(Arrays.asList("zhangsan", "lisi", "zhangsan", "wangwu", "lisi", "wangwu"));
        JavaRDD<Row> rowRDD = parallelize.map(RowFactory::create);
        List<StructField> fields = new ArrayList<>();
        fields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
        StructType schema = DataTypes.createStructType(fields);
        Dataset df = sqlContext.createDataFrame(rowRDD, schema);
        df.registerTempTable("user");

        sqlContext.udf().register("StringCount", new UserDefinedAggregateFunction() {
            /**
             * 初始化一个内部的自定义的值，在Aggredate之前每组数据的初始化结果
             * @param buffer
             */
            @Override
            public void initialize(MutableAggregationBuffer buffer) {
                buffer.update(0,0);
            }

            /**
             * 可以认为一个个地将组内的字段值传递过来，实现拼接的逻辑
             * buffer.getInt(0)获取的时候上一次聚合后的值
             * 相当于map端的combiner，combiner就是对每一个map task的处理结果进行一次小的聚合
             * 那么，之后的聚合发生在Reduce端
             * 含义：在进行聚合的时候，当有新的值进来，对分组后的聚合如何进行计算
             * @param buffer
             * @param input
             */
            @Override
            public void update(MutableAggregationBuffer buffer, Row input) {
                buffer.update(0,buffer.getInt(0)+1);
            }

            /**
             * 合并update操作，可能是针对一个分组内部的部分数据，在某个节点上发生的
             * 但是可能一个分组内的数据会分布在多个节点上处理
             * 此时就要用merge操作，将各个节点上分布式拼接好的串合并起来
             * buffer1.getInt(0)大聚合的时候，上一次聚合后的值
             * buffer2.getInt(0)这次计算传入进来的update的数据结果
             * 最后在分布式节点完成后需要进行全局级别的merge操作
             * @param buffer1
             * @param buffer2
             */
            @Override
            public void merge(MutableAggregationBuffer buffer1, Row buffer2) {
                buffer1.update(0, buffer1.getInt(0)+buffer2.getInt(0));
            }

            /**
             * 在进行聚合操作的时候需要处理的数据的结果的类型
             * @return
             */
            @Override
            public StructType bufferSchema() {
                return DataTypes.createStructType(Arrays.asList(DataTypes.createStructField("buffer",DataTypes.IntegerType,true)));
            }

            /**
             * 在最后返回一个和dataType方法类型一致的类型，返回UDF最后的计算结果
             * @param buffer
             * @return
             */
            @Override
            public Object evaluate(Row buffer) {
                return buffer.getInt(0);
            }

            /**
             * 指定UDAF函数计算之后返回的结果类型
             * @return
             */
            @Override
            public DataType dataType() {
                return DataTypes.IntegerType;
            }

            /**
             * 指定输入字段的类型和字段
             * @return
             */
            @Override
            public StructType inputSchema() {
                return DataTypes.createStructType(Arrays.asList(DataTypes.createStructField("name123",DataTypes.StringType,true)));
            }

            /**
             * 用以标记针对给定的一组输入，UDAF是否总是生成相同的结果
             * 确保一致性，一半用true
             * @return
             */
            @Override
            public boolean deterministic() {
                return true;
            }
        });
        sqlContext.sql("select name,StringCount(name) as strCount from user group by name").show();
    }
}
