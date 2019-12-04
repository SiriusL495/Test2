package com.SparkStreaming.demo02;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class WindowOperator {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf()
                .setAppName("WindowOperator")
                .setMaster("local[2]");
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(5));
        /**
         * 设置日志的级别为WARN，不打印info
         */
        jsc.sparkContext().setLogLevel("WARN");
        /**
         * 没有优化的窗口函数可以不设置checkpoint目录
         * 优化的窗口函数必须设置checkpoint目录
         */
        jsc.checkpoint("./checkpoint");
        JavaReceiverInputDStream<String> searchLogsDStream = jsc.socketTextStream("virhost00",9999);
        JavaDStream<String> window = searchLogsDStream.window(Durations.seconds(15),Durations.seconds(5));
        JavaDStream<String> searchWordsDStream = searchLogsDStream.flatMap((FlatMapFunction<String, String>) s -> Arrays.asList(s.split(" ")).iterator());
        //要将其映射为(searchWord，1)的tuple格式
        JavaPairDStream<String,Integer> searchWordPairDStream = searchWordsDStream.mapToPair((PairFunction<String,String,Integer>) searchWord->{
           return new Tuple2<String,Integer>(searchWord,1);
        });
        /**
         * 每隔10秒计算最近60秒内的数据，那么整个窗口的大小就是60秒，里面应该有多个RDD聚合起来，然后一起执行reduceByKeyAndWindow
         * reduceByKeyAndWindow是针对窗口操作的，而不是针对DStream进行操作的
         * Durations.seconds(15)，每隔5秒计算最近15秒的批次
         * Durations.seconds(5)
         */
        //JavaPairDStream<String,Integer> searchWordCountsDStream = searchWordPairDStream.reduceByKeyAndWindow(Integer::sum,Durations.seconds(15),Durations.seconds(5));
        /**
         * window窗口操作的优化：
         * v1+v2就是加的进来的一批次
         * v1-v2就是减去出去的一批次
         */
        /**
         * abc
         * abd
         * acd
         */
        JavaPairDStream<String,Integer> searchWordCountsDStream = searchWordPairDStream.reduceByKeyAndWindow(Integer::sum,(Function2<Integer,Integer,Integer>)(v1,v2)-> v1-v2,Durations.seconds(15),Durations.seconds(5));
        searchWordCountsDStream.print();
        jsc.start();
        jsc.awaitTermination();
        jsc.stop();
     }
}
