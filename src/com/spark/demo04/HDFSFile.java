package com.spark.demo04;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class HDFSFile {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("456");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("hdfs://spark**:9000/wordcount.txt");
        JavaRDD<String> words = lines.flatMap((String s)->{
            return Arrays.asList(s.split("")).iterator();
        });
        long total = words.count();
        System.out.println(total);
        sc.close();
    }
}
