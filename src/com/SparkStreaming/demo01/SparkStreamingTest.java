package com.SparkStreaming.demo01;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;

public class SparkStreamingTest {
    public static void main(String[] args) throws InterruptedException{
        SparkConf conf = new SparkConf()
                .setAppName("SparkStreamingTest")
                .setMaster("local[2]");//[2]表示双线程
        final JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        JavaStreamingContext jsc = new JavaStreamingContext(sc, Durations.seconds(5));
        JavaReceiverInputDStream<String> socket = jsc.socketTextStream("virhost00",9999);
        JavaDStream<String> words = socket.flatMap((String lines)-> Arrays.asList(lines.split(" ")).iterator());
        JavaPairDStream<String,Integer> pairWords = words.mapToPair((PairFunction<String, String, Integer>) s -> new Tuple2<String,Integer>(s,1));

        JavaPairDStream<String,Integer> reduceByKey = pairWords.reduceByKey(Integer::sum);

        reduceByKey.foreachRDD((JavaPairRDD<String,Integer> rdd)->{
            System.out.println("Driver......");
            SparkContext context = rdd.context();
            JavaSparkContext javaSparkContext = new JavaSparkContext(context);
            Broadcast<String> broadcast = javaSparkContext.broadcast("hello");
            String value = broadcast.value();
            //广播对象只是在Driver端获取一下
            System.out.println(value);
            JavaPairRDD<String,Integer> mapToPair = rdd.mapToPair((PairFunction<Tuple2<String, Integer>, String, Integer>) tuple -> {
                System.out.println("Execute......");
                return new Tuple2<String,Integer>(tuple._1+"~",tuple._2);
            });
            mapToPair.foreach(new VoidFunction<Tuple2<String, Integer>>() {
                @Override
                public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                    System.out.println(stringIntegerTuple2);
                }
            });
        });
        jsc.start();
        jsc.awaitTermination();
        jsc.stop();
    }
}
