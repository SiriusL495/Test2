package com.spark.demo10;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;

import java.util.Arrays;
import java.util.List;

public class BroadcastVariable {
    /**
     * Spark的算子，如果在一个算子的函数中使用到了某个外部的变量，那么这个变量的值会被拷贝到每个task中。
     * 此时，每个task只能操作自己的那份变量副本。
     * 如果多个task想要共享多个变量，做不到。
     * Spark为此专门提供了两种共享变量，Broadcast Variable和Accumulator
     * 广播变量：将使用到的变量，仅仅为每个节点拷贝一份，用于优化性能。
     * 累加变量：让多个task共同操作一份变量，可以进行累加操作
     */
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("BroadcastVariable")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        /**
         * 在Java中，创建共享变量就是调用SparkContext的broadcast方法
         * 获取的返回结果是Broadcast<T>类型
         */
        final int factor = 3;
        final Broadcast<Integer> factorBroadcast = sc.broadcast(factor);
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> numbers = sc.parallelize(numberList);

        JavaRDD<Integer> multiNums = numbers.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer v1) throws Exception {
                int factor = factorBroadcast.value();
                return v1 * factor;
            }
        });
        multiNums.foreach((Integer t) -> {
            System.out.println(t);
        });
    }
}
