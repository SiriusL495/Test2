package com.spark.demo03;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ParallelizedCollection {
    public static void main(String[] args) {
        p2();
    }

    private static void p1(){
        SparkConf conf = new SparkConf().setAppName("*2").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        JavaRDD<Integer> nums = sc.parallelize(arr);
        //1+2=3,3+3=6,6+4=10,10+5=15......
//        int sum = nums.reduce((Integer integer, Integer integer2)->{
//            return integer+integer2;
//        });
        int sum = nums.reduce(Integer::sum);
        System.out.println(sum);
        sc.close();
    }

    private static void p2(){
        SparkConf conf = new SparkConf().setAppName("456").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt");
        JavaRDD<String> words = lines.flatMap((String s)->{
            return Arrays.asList(s.split("")).iterator();
        });
        long total = words.count();
        System.out.println(total);
        sc.close();
    }

}
