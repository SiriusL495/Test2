package com.spark.Homework.Homework01;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;

public class JavaWordCount {
    public static void main(String[] args) {
//        SparkConf conf = new SparkConf().setAppName("JavaWordCountLocal").setMaster("local");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        JavaRDD<String> lines = sc.textFile("./words");
//
//        JavaRDD<String> words = lines.flatMap((String line) -> {
//            return Arrays.asList(line.split(" ")).iterator();
//        });
//
//        JavaPairRDD<String, Integer> pairs = words.mapToPair((String word) -> {
//            return new Tuple2<String, Integer>(word, 1);
//        });
//
//        JavaPairRDD<String, Integer> wordcounts = pairs.reduceByKey((Integer integer, Integer integer2) -> {
//            return integer + integer2;
//        });
//
//        wordcounts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
//            @Override
//            public void call(Tuple2<String, Integer> wordcount) throws Exception {
//                System.out.println(wordcount._1 + " 产生了 " + wordcount._2 + " 次");
//            }
//        });
//        sc.stop();

    }
}
