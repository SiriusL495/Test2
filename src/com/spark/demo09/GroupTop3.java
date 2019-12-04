package com.spark.demo09;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

public class GroupTop3 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("GroupTop3")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("./scores");
        JavaPairRDD<String,Integer> pairs = lines.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                String[] linesSplited = s.split(" ");
                return new Tuple2<>(linesSplited[0], Integer.parseInt(linesSplited[1]));
            }
        });
        JavaPairRDD<String,Iterable<Integer>> groupedPairs = pairs.groupByKey();
        JavaPairRDD<String,Iterable<Integer>> top3Score = groupedPairs.mapToPair(new PairFunction<Tuple2<String, Iterable<Integer>>, String, Iterable<Integer>>() {
            @Override
            public Tuple2<String,Iterable<Integer>> call(Tuple2<String, Iterable<Integer>> classScores) throws Exception {
                Integer[] top3 = new Integer[3];
                String className = classScores._1;
                for (Integer score : classScores._2) {
                    for (int i = 0; i < 3; i++) {
                        if (top3[i] == null) {
                            top3[i] = score;
                            break;
                        } else if (score > top3[i]) {
                            for (int j = 2; j > i; j--) {
                                top3[j] = top3[j - 1];
                            }
                            top3[i] = score;
                            break;
                        }
                    }
                }
                return new Tuple2<String, Iterable<Integer>>(className, Arrays.asList(top3));
            }
        });
        top3Score.foreach((Tuple2<String,Iterable<Integer>> t)->{
            System.out.println("class:"+t._1);
            for (Integer score : t._2) {
                System.out.println(score);
            }
        });
    }
}
