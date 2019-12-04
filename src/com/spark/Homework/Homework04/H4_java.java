package com.spark.Homework.Homework04;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class H4_java {
    public static void main(String[] args) {
        //T1_1();
        //T1_2();
        //T4();
        T5_2();
    }

    private static void T1_1() {
        SparkConf conf = new SparkConf().setAppName("T1").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> scoreList = Arrays.asList(
                new Tuple2<>("class1", 90),
                new Tuple2<>("class2", 80),
                new Tuple2<>("class1", 89),
                new Tuple2<>("class2", 87)
        );
        JavaPairRDD<String, Iterable<Integer>> scores = sc.parallelizePairs(scoreList).groupByKey();
        scores.foreach((Tuple2<String, Iterable<Integer>> t) -> {
            System.out.println(t._1);
            for (Integer i : t._2) {
                System.out.println(i);
            }
            System.out.println("-------------");
        });
        sc.close();
    }

    private static void T1_2() {
        SparkConf conf = new SparkConf().setAppName("T1").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> scoreList = Arrays.asList(
                new Tuple2<>("class1", 90),
                new Tuple2<>("class2", 80),
                new Tuple2<>("class1", 89),
                new Tuple2<>("class2", 87)
        );
        JavaPairRDD<String, Integer> scores = sc.parallelizePairs(scoreList).reduceByKey(Integer::sum);
        scores.foreach((Tuple2<String, Integer> t) -> {
            System.out.println(t._1 + "班的总分为：" + t._2);
        });
        sc.close();
    }

    private static void T4() {
        SparkConf conf = new SparkConf().setAppName("13").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<Integer, String>> stuList = Arrays.asList(
                new Tuple2<>(1, "Spark"),
                new Tuple2<>(2, "Maven"),
                new Tuple2<>(3, "Hadoop")
        );
        List<Tuple2<Integer, Integer>> stuScore = Arrays.asList(
                new Tuple2<>(1, 100),
                new Tuple2<>(2, 95),
                new Tuple2<>(3, 65)
        );
        JavaPairRDD<Integer, String> stu = sc.parallelizePairs(stuList);
        JavaPairRDD<Integer, Integer> scores = sc.parallelizePairs(stuScore);
        JavaPairRDD<Integer, Tuple2<String, Integer>> stuScores = stu.join(scores);
        stuScores.foreach(System.out::println);
        sc.close();
    }

    private static void T5_1() {
        SparkConf conf = new SparkConf().setAppName("13").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> words1 = Arrays.asList(
                new Tuple2<>("hello", 3),
                new Tuple2<>("hello", 2),
                new Tuple2<>("world", 7),
                new Tuple2<>("hello", 12),
                new Tuple2<>("you", 9)
        );

        List<Tuple2<String, Integer>> words2 = Arrays.asList(
                new Tuple2<>("hello", 21),
                new Tuple2<>("world", 24),
                new Tuple2<>("hello", 25),
                new Tuple2<>("you", 28)
        );

        JavaPairRDD<String,Integer> stu = sc.parallelizePairs(words1);
        JavaPairRDD<String,Integer> scores = sc.parallelizePairs(words2);
        JavaPairRDD<String, Tuple2<Integer, Integer>> stuScores = stu.join(scores);
        stuScores.foreach((Tuple2<String,Tuple2<Integer,Integer>> t)->{
            System.out.println(t._1+" "+t._2._1+" "+t._2._2);
        });
        sc.close();
    }

    private static void T5_2() {
        SparkConf conf = new SparkConf().setAppName("13").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> words1 = Arrays.asList(
                new Tuple2<>("hello", 3),
                new Tuple2<>("hello", 2),
                new Tuple2<>("world", 7),
                new Tuple2<>("hello", 12),
                new Tuple2<>("you", 9)
        );

        List<Tuple2<String, Integer>> words2 = Arrays.asList(
                new Tuple2<>("hello", 21),
                new Tuple2<>("world", 24),
                new Tuple2<>("hello", 25),
                new Tuple2<>("you", 28)
        );

        JavaPairRDD<String,Integer> stu = sc.parallelizePairs(words1);
        JavaPairRDD<String,Integer> scores = sc.parallelizePairs(words2);
        JavaPairRDD<String, Tuple2<Iterable<Integer>, Iterable<Integer>>> stuScores = stu.cogroup(scores);
        stuScores.foreach((Tuple2<String,Tuple2<Iterable<Integer>,Iterable<Integer>>> t)->{
            System.out.println(t._1+" "+t._2._1+" "+t._2._2);
        });
        sc.close();
    }

}
