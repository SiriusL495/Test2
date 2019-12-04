package com.spark.demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;

public class JavaWordCount {

    public static void main(String[] args) {
        /**
         * 第一步：创建了SparkConf对象，设置Spark的配置信息
         * setMaster("local")是用来设置应用程序需要连接的Spark集群的master节点的url
         * 此时设置为local表示在本地运行
         */
        SparkConf conf = new SparkConf().setAppName("JavaWordCountLocal").setMaster("local");
        /**
         * 第二步：创建JavaSparkContext对象
         * 在Spark中，SparkContext是Spark所有功能的一个入口，无论是Java、Scala、Python编写都必须有一个SparkContext
         * 作用包括初始化Spark程序所需的一些核心组件，但是在不同的应用程序中，使用SparkContext是不同的
         * JavaSparkContext，Scala使用原生的SparkContext。依次类推，Spark SQL的程序使用的就是SQLContext和HiveContext
         */
        JavaSparkContext sc = new JavaSparkContext(conf);
        /**
         * 第三步：针对输入源(HDFS,本地文件等数据集)，创建一个初始的RDD
         * RDD有Partition，输入源的数据会被打散，分配到RDD的每个Partition中，从而形成分布式的数据集
         * 在Java中，创建的普通的RDD都叫作JavaRDD
         * SparkContext中，用于根据文件类型的输入源创建RDD的方法，叫作textFile方法
         */
        JavaRDD<String> lines = sc.textFile("./words");
        /**
         * 第四步：对于初始化的RDD进行Transformation操作，也就是一些转化计算的操作。
         * 通常，这些操作会通过创建function并且配合RDD的map或flatMap等等算子来执行
         *lambda表达式：本质是内部类
         * 先将每一行拆分成单个单词
         * flatMapFunction有两个泛型参数，分别代表输入和输出
         * 这里的flatMap就是将RDD的一个元素拆分成一个或多个元素
         */
//        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
//            @Override
//            public Iterator<String> call(String line) throws Exception {
//                return Arrays.asList(line.split(" ")).iterator();
//            }
//        });
        JavaRDD<String> words = lines.flatMap((String line) -> {
            return Arrays.asList(line.split(" ")).iterator();
        });

        /**
         * 第五步：需要将每一个单词映射为(单词,1)的格式
         * 只有这样才能根据单词出现的次数累加
         * mapToPair其实就是将每个元素映射为一个(v1,v2)这样的Tuple2类型的元素
         * scala中的Tuple2包含了两个值，mapToPair这个算子，就是与PairFunction配合使用
         * pairFunction的第一个泛型参数代表了输入类型
         * 第二个和第三个泛型参数，代表输出的Tuple2的第一和第二个值
         */

//        JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
//            @Override
//            public Tuple2<String, Integer> call(String word) throws Exception {
//                return new Tuple2<String, Integer>(word, 1);
//            }
//        });

//        JavaPairRDD<String, Integer> pairs = words.mapToPair((String word) -> {
//            return new Tuple2<String, Integer>(word, 1);
//        });
//        /**
//         * 第六步：需要以单词作为key，统计每个单词出现的次数
//         * 这里使用reduceByKey算子，对于每个key对应的value都进行reduce操作
//         *把key相同的元素value相加，返回RDD中的元素，也就是Tuple
//         * 产生结果
//         */
////        JavaPairRDD<String, Integer> wordcounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
////            @Override
////            public Integer call(Integer integer, Integer integer2) throws Exception {
////                return integer + integer2;
////            }
////        });
//
//        JavaPairRDD<String, Integer> wordcounts = pairs.reduceByKey((Integer integer, Integer integer2) -> {
//            return integer + integer2;
//        });
//        /**
//         * 目前为止通过几个Spark算子操作，已经统计处了单词的次数
//         * 但是之前使用的flatMap，mapToPair，reduceByKey这种操作，都叫做transformation算子
//         * 一个spark应用中光有transformation操作是不行的，需要action算子
//         * 最后使用一个叫foreach的action算子输出结果集
//         */
//        wordcounts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
//            @Override
//            public void call(Tuple2<String, Integer> wordcount) throws Exception {
//                System.out.println(wordcount._1 + " 产生了 " + wordcount._2 + " 次");
//            }
//        });
//        sc.stop();
    }

}
