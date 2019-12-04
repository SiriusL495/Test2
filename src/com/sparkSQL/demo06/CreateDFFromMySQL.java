package com.sparkSQL.demo06;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CreateDFFromMySQL {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("CreateDFFromMySQL")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        /**
         * 读取MySQL数据库表，加载为DataFrame
         */
        Map<String,String> options = new HashMap<String,String>();
        options.put("url","jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        options.put("driver","com.mysql.cj.jdbc.Driver");
        options.put("user","root");
        options.put("password","123456");
        options.put("dbtable","person");

        Dataset person = sqlContext.read().format("jdbc").options(options).load();
        person.show();
        person.registerTempTable("person");

        /**
         * 读取MySQL数据库表
         */
        DataFrameReader reader = sqlContext.read().format("jdbc");
        reader.option("url","jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        reader.option("driver","com.mysql.cj.jdbc.Driver");
        reader.option("user","root");
        reader.option("password","123456");
        reader.option("dbtable","score");
        Dataset score = reader.load();
        score.show();
        score.registerTempTable("score");

        Dataset result = sqlContext.sql("select person.id,person.name,score.score from person,score where person.name = score.name");
        result.show();

        /**
         * 将DataFrame结果保存到MySQL中
         */
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        //result
        result.write().mode(SaveMode.Overwrite).jdbc("jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC","result",properties);
        sc.stop();

    }
}
