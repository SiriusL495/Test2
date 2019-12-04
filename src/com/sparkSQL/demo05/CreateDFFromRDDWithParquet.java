package com.sparkSQL.demo05;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;

public class CreateDFFromRDDWithParquet {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("CreateDFFromRDDWithParquet")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> jsonRDD = sc.textFile("./json");
        Dataset ds = sqlContext.read().json(jsonRDD);
        /**
         * 将DataFrame保存成parquet文件，SaveMode指定存储文件的形式
         * 保存成parquet文件的两种方式
         */
        /**
         * SaveMode指定文件保存时的模式：
         * OverWrite：覆盖
         * Append：追加
         * ErrorIfExists：如果存在就报错
         * Ignore：如果存在就忽略
         */
        ds.write().mode(SaveMode.Overwrite).parquet("./parquet");
        ds.write().mode(SaveMode.Overwrite).format("parquet").save("./parquet2");
        ds.show();
        /**
         * 加载parquet文件成DataFrame的两种方式
         */
        Dataset load = sqlContext.read().format("parquet").load("./parquet2");
        load = sqlContext.read().parquet("./parquet2");
        load.show();
        sc.stop();
    }
}
