package com.spark.demo07;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class CheckpointTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("CheckpointTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        //将代码保存在定义的目录下
        sc.setCheckpointDir("./checkpoint");
        JavaRDD<Integer> para = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        para.checkpoint();
        para.count();
        sc.stop();
    }
}
