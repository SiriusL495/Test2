package com.spark.demo08;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

public class SecondarySort3 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("SecondarySort3")
                .setMaster("local");
        SparkContext sc = new SparkContext(conf);
    }
}
