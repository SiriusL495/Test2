package com.SparkStreaming.demo01;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
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
import java.util.List;

/**
 * 主要功能：
 * 1.为SparkStreaming中每一个key维护一份state状态，state类型可以是任意类型，可以说是一个自定义对象。更新函数也可以是自定义的
 * 2.通过更新函数对该key的状态不断更新，对于每个新的batch而言，SparkStreaming会在使用UpdateStateByKeyOperator的时候为已经存在的key进行state状态更新
 * 3.如果要不断更新每个key的state，就要涉及到状态的容错和保存，这个时候就需要开启checkpoint机制和功能。
 */
public class UpdateStateByKeyOperator {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf()
                .setAppName("UpdateStateByKeyOperator")
                .setMaster("local[2]");
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(5));
        /**
         * 设置checkpoint目录
         * 多久会将内存中的数据(每一个key所对应的状态)写入到磁盘上一份
         * 假如设置batchInternal小于10秒，那么10秒会将内存中的数据写入到磁盘一份
         * 如果大于10秒，那么就以batchInternal为准
         */
        jsc.checkpoint("./checkpoint");

        JavaReceiverInputDStream<String> lines= jsc.socketTextStream("virhost00",9999);
        JavaDStream<String> words = lines.flatMap((String s)->{
           return Arrays.asList(s.split(" ")).iterator();
        });

        JavaPairDStream<String,Integer> ones = words.mapToPair((PairFunction<String, String, Integer>) s -> new Tuple2<String,Integer>(s,1));

        JavaPairDStream<String,Integer> counts = ones.updateStateByKey((Function2<List<Integer>, Optional<Integer>, Optional<Integer>>) (values, state) -> {
            /**
             * value:经过分组最后这个key所对应的value
             * state:这个key表示在本次之前的状态
             */
            Integer updateValue = 0;
            if(state.isPresent()){
                updateValue=state.get();
            }
            for(Integer value:values){
                updateValue+=value;
            }
            return Optional.of(updateValue);
        });

        counts.print();

        jsc.start();
        jsc.awaitTermination();
        jsc.close();

    }
}
