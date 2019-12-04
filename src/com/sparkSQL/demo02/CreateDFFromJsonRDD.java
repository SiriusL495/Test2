package com.sparkSQL.demo02;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SQLContext;

import java.util.Arrays;

/**
 * 读取json格式的RDD来创建DataFrame
 */
public class CreateDFFromJsonRDD {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("CreateDFFromJsonRDD")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> nameRDD = sc.parallelize(Arrays.asList(
                "{\"name\":\"zhangsan\",\"age\":\"18\"}",
                "{\"name\":\"lisi\",\"age\":\"19\"}",
                "{\"name\":\"wangwu\",\"age\":\"17\"}"
        ));
        JavaRDD<String> scoreRDD = sc.parallelize(Arrays.asList(
                "{\"name\":\"zhangsan\",\"score\":\"97\"}",
                "{\"name\":\"lisi\",\"score\":\"68\"}",
                "{\"name\":\"wangwu\",\"score\":\"85\"}"
        ));

        Dataset namedf = sqlContext.read().json(nameRDD);
        namedf.show();
        Dataset scoredf = sqlContext.read().json(scoreRDD);
        scoredf.show();
        /**
         * select t1.name,t1.age,t2.score from t1,t2 where t1.name = t2.name
         */
        namedf.join(scoredf,namedf.col("name").equalTo(scoredf.col("name")))
                .select(namedf.col("name"),namedf.col("age"),scoredf.col("score")).show();

        //注册成临时表
        namedf.registerTempTable("name");
        scoredf.registerTempTable("score");
        /**
         *
         */
        Dataset result = sqlContext.sql("select name.name,name.age,score.score " +
                "from name join score " +
                "on name.name = score.name");
        result.show();
    }
}
