package com.spark.demo07;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class PersistTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("persist").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        //JavaRDD<String> lines = sc.textFile("C:\\Users\\SiriusL\\Desktop\\123.txt").cache();
        JavaRDD<String> lines = sc.textFile("C:\\Users\\SiriusL\\Desktop\\123.txt").cache();
        long beginTime = System.currentTimeMillis();
        long count = lines.count();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("r1 cost: "+(endTime-beginTime)+" ms");

        beginTime = System.currentTimeMillis();
        count = lines.count();
        System.out.println(count);
        endTime = System.currentTimeMillis();
        System.out.println("r2 cost: "+(endTime-beginTime)+" ms");

        sc.close();

        //2472  1941
        //7851  136
    }

}
