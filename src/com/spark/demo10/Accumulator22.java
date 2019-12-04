package com.spark.demo10;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.LongAccumulator;

import java.util.Arrays;
import java.util.List;


public class Accumulator22 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("Accumulator22")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        LongAccumulator sum = sc.sc().longAccumulator();
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        JavaRDD<Integer> nums = sc.parallelize(numList);
        nums.foreach(sum::add);
        System.out.println(sum.value());
    }
}
