package com.sparkSQL.demo08;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UDFDemo {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("UDFDemo")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> parallelize = sc.parallelize(Arrays.asList("zhangsan","lisi","wangwu"));
        JavaRDD<Row> rowRDD = parallelize.map(RowFactory::create);

        /**
         * 动态创建Schema方式加载DataFrame
         */
        List<StructField> fields = new ArrayList<>();
        fields.add(DataTypes.createStructField("name",DataTypes.StringType,true));
        StructType schema = DataTypes.createStructType(fields);
        Dataset df = sqlContext.createDataFrame(rowRDD,schema);
        df.registerTempTable("user");

        sqlContext.udf().register(
                "StringLen", (UDF1<String, Integer>) String::length,DataTypes.IntegerType
        );
        sqlContext.sql("select name,StringLen(name) as length from user").show();

        sc.stop();
    }
}
