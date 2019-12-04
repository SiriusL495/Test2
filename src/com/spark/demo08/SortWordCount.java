package com.spark.demo08;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class SortWordCount {

//    public static void main(String[] args) {
//        SparkConf conf = new SparkConf().setAppName("SortWordCount").setMaster("local");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        JavaRDD<String> lines = sc.textFile("./words");
//        JavaRDD<String> words = lines.flatMap((String s) -> {
//            return Arrays.asList(s.split(" ")).iterator();
//        });
//        JavaPairRDD<String,Integer> pairs = words.mapToPair((String word)->{
//           return new Tuple2<String,Integer>(word,1);
//        });
//        JavaPairRDD<String,Integer> wordcounts = pairs.reduceByKey(Integer::sum);
//        /**
//         * 到此为止，获得每个单词出现的次数
//         * 但是需求：按照每个单词出现的次数降序排序
//         * (you,2)(hello,3)
//         * 转换成(3.hello)(2,you)的格式
//         */
//        //key-value的反转映射
//        JavaPairRDD<Integer,String> countWords = wordcounts.mapToPair((Tuple2<String,Integer> t)->{
//           return new Tuple2<Integer,String>(t._2,t._1);
//        });
//        JavaPairRDD<Integer,String> sorted = countWords.sortByKey(false);
//        JavaPairRDD<String, Integer> sortedWordCounts = sorted.mapToPair((Tuple2<Integer,String> t)->{
//           return new Tuple2<String,Integer>(t._2,t._1);
//        });
//        sortedWordCounts.foreach((Tuple2<String,Integer> wc)->{
//            System.out.println(wc._1+" 出现了 "+wc._2+" 次");
//        });
//    }
}
