package com.sparkSQL.demo01;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

/**
 * 读取json格式文件创建DataFrame
 * 1.读取json格式
 * 2.df。show()默认显示前20条，可以加参数n来显示n行
 * 3.df.javaRDD将DataFrame转换成RDD
 * 4.ds.printSchema()显示DataFrame中Schema的相关信息
 * 5.想使用SQL，首先要.registerTempTable()再去使用SQL
 * 6.不能读取嵌套的json文件
 */
public class SQLTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("sqltest")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlcontext = new SQLContext(sc);
        /**
         * DataFrame有数据，有列的schema
         * sqlContext读取json文件加载成DataFrame，DataFrame中的列会按照Ascii码排序
         * 写sql查询出来的dataFrame会按照指定的字段显示列
         */
        Dataset ds = sqlcontext.read().format("json").load("./json");
        ds.show();
        System.out.println("-----------");
        ds.printSchema();
        Dataset ds2 = ds.select(ds.col("name"), ds.col("age")).where(ds.col("age").gt(18));
        ds2.show();
        /**
         * 将DataFrame注册成临时表
         * test1这张表不在内存中，也不在磁盘中，相当于是一个指针指向源文件
         * 底层操作解析Spark job读取原文件
         */
        ds2.registerTempTable("test1");
        Dataset ds3 = sqlcontext.sql("select * from test1 where age > 18");
        ds3.show();

        /**
         * 这种dataFrame属于RDD，返回的Row立即变成一行
         */
        JavaRDD<Row> javaRDD = ds.javaRDD();
        javaRDD.foreach((Row row) -> {
            System.out.println(row.get(1));
            row.getAs(1);
            System.out.println(row.getAs(1)+"");
            System.out.println("==================");
            row.getAs("name");
            System.out.println(row.getAs("name")+"");
            System.out.println("--------------------");
        });
        sc.stop();
    }
}
