package com.spark.demo05;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ActionOperation {
    public static void main(String[] args) {
        //reduce();
        //collect();
        //count();
        //take();
        //countByKey();
        //saveAsTestFile();
        countByValue();
    }

    /**
     * reduce的本质是将多个元素聚合成一个元素
     */
    private static void reduce(){
        SparkConf conf = new SparkConf().setAppName("reduce").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        JavaRDD<Integer> numbers = sc.parallelize(numberList);
        int count =  numbers.reduce(Integer::sum);
        System.out.println(count);
        sc.close();
    }

    private static void collect(){
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        JavaRDD<Integer>numbers = sc.parallelize(numberList);
        JavaRDD<Integer>doubleNum = numbers.map((Integer i)->{
            return i*2;
        });
        /**
         * 不用foreach操作，在远程集群上遍历RDD中的元素
         * 而使用collect将分布在远程集群上的doubleNums RDD数据拉到本地
         * 如果RDD中给的数据比较大，不建议使用，可能导致oom异常，内存溢出
         */
        List<Integer> doubleNumList = doubleNum.collect();
        for(Integer i:doubleNumList){
            System.out.println(i);
        }
        sc.close();
    }

    private static void count(){
        SparkConf conf = new SparkConf().setAppName("count").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        JavaRDD<Integer>numbers = sc.parallelize(numberList);
        long ct = numbers.count();
        System.out.println(ct);
        sc.close();
    }

    private static void take(){
        SparkConf conf = new SparkConf().setAppName("take").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        JavaRDD<Integer>numbers = sc.parallelize(numberList);
        /**
         * take和collect都是远程集群获取RDD数据
         * 但是，collect时获取RDD所有数据，take获取前n个数据
         */
        List<Integer> top3Nums = numbers.take(3);
        for (Integer i:top3Nums){
            System.out.println(i);
        }
        sc.close();
    }

    private static void countByKey(){
        SparkConf conf = new SparkConf().setAppName("countByKey").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String,String>>scoreList = Arrays.asList(
                new Tuple2<>("class1","zhangsan"),
                new Tuple2<>("class2","lisi"),
                new Tuple2<>("class1","wangwu"),
                new Tuple2<>("class2","laoliu"),
                new Tuple2<>("class1","goudan")
        );
        JavaPairRDD<String,String>students = sc.parallelizePairs(scoreList);
        Map<String,Long> ct = students.countByKey();
        for(Map.Entry<String,Long>stuct:ct.entrySet()){
            System.out.println(stuct.getKey()+" "+stuct.getValue());
        }
        sc.close();
    }

    /**
     * 对RDD中相同的元素进行计数
     */
    private static void countByValue(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String,String>>scoreList = Arrays.asList(
                new Tuple2<>("zhangsan","18"),
                new Tuple2<>("lisi","19"),
                new Tuple2<>("wangwu","17"),
                new Tuple2<>("zhangsan","18"),
                new Tuple2<>("ddd","17"),
                new Tuple2<>("qqq","19"),
                new Tuple2<>("eee","18"),
                new Tuple2<>("xxx","17")
        );
        JavaPairRDD<String,String>students = sc.parallelizePairs(scoreList);
        Map<Tuple2<String, String>, Long> ct = students.countByValue();
        for(Map.Entry<Tuple2<String, String>, Long> stuct:ct.entrySet()){
            System.out.println(stuct.getKey()+" "+stuct.getValue());
        }
        sc.close();
    }

    private static void saveAsTestFile(){
        SparkConf conf = new SparkConf().setAppName("reduce");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        JavaRDD<Integer>numbers = sc.parallelize(numberList);
        JavaRDD<Integer> doubleNum = numbers.map((Integer i)->{
           return i*2;
        });
        doubleNum.saveAsTextFile("hdfsPath");
        sc.close();
    }

}
