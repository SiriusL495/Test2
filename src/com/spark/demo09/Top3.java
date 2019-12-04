package com.spark.demo09;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.List;

public class Top3 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Top3").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("./top3");
        JavaPairRDD<Integer,String> pairs = lines.mapToPair((PairFunction<String, Integer, String>) s -> {
           return new Tuple2<Integer,String>(Integer.parseInt(s), s);
        });
        JavaPairRDD<Integer,String> sortedPairs = pairs.sortByKey(false);
        JavaRDD<Integer> sortedNumbers = sortedPairs.map((Tuple2<Integer,String> t)->{
           return t._1;
        });
        List<Integer> sortedNumberList = sortedNumbers.take(3);
        System.out.println(sortedNumberList);
        sc.close();
    }
}
