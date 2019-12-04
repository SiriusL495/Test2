package com.spark.Homework.Homework02;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class T1_java {
    public static void main(String[] args) {
        T1();
    }

    private static void T1(){
        SparkConf conf = new SparkConf().setAppName("T1").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        JavaRDD<Integer> nums = sc.parallelize(list);

        JavaRDD<Integer> nums_filter = nums.filter((Integer n)->{
           return n%2==0;
        });

        JavaRDD<Integer> nums_map = nums_filter.map((Integer n)->{
            return n*3;
        });

        nums_map.foreach((Integer n)->{
            System.out.println(n);
        });
    }

}
