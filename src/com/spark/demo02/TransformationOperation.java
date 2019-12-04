package com.spark.demo02;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Int;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TransformationOperation {
    public static void main(String[] args) {
//        map();
//        filter();
//        flatMap();
//        groupByKey();
//        reduceByKey();
//        sortByKey();
//        join();
        coGroup();
    }

    /**
     * 创建一个集合，用Spark运算，将集合中的每一个值*2并输出结果
     */
    private static void map() {
        SparkConf conf = new SparkConf().setAppName("*2").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);

        JavaRDD<Integer> nums = jsc.parallelize(arr);
        /**
         * map算子，将当前集合每个元素都*2
         * 对于任何类型的RDD都可以调用
         * 在Java，map算子接收的参数是function对象
         * 创建的function对象，一定要让你设置第二个泛型参数
         * 这个法耐心那个参数就是返回的新元素的类型
         * 同时call方法的返回类型也必须与第二个泛型同步
         * 在call方法内部可以对原始的每一个元素进行处理计算并返回新元素。
         * 所有新元素会组成一个新的RDD
         */
        JavaRDD<Integer> nums2 = nums.map((Integer integer) -> {
            return integer * 2;
        });
        nums2.foreach(System.out::println);

        jsc.stop();
    }

    //过滤奇数
    private static void filter() {
        SparkConf conf = new SparkConf().setAppName("*2").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        JavaRDD<Integer> nums = jsc.parallelize(arr);

        JavaRDD<Integer> even = nums.filter((Integer integer) -> {
            return integer % 2 == 0;
        });

        even.foreach(System.out::println);
        jsc.stop();
    }

    private static void flatMap() {
        SparkConf conf = new SparkConf().setAppName("*2").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        List<String> lineList = Arrays.asList("hello you", "hello me", "hello everybody");
        JavaRDD<String> lines = jsc.parallelize(lineList);
        /**
         * 对于RDD执行flatMap算子，将每一行文本拆分为多个单词
         * flatmap在Java中接收的参数是FlatMapFunction
         * 需要定义FlatMapFunction的第二个泛型，即代表了返回的新元素的类型
         * call方法返回的类型是iterator
         */
        JavaRDD<String> words = lines.flatMap((String s) -> {
            return Arrays.asList(s.split(" ")).iterator();
        });

        words.foreach(System.out::println);
        jsc.stop();
    }

    private static void groupByKey() {
        SparkConf conf = new SparkConf().setAppName("*2").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        List<Tuple2<String, Integer>> scoreList = Arrays.asList(
                new Tuple2<String, Integer>("class1", 90),
                new Tuple2<String, Integer>("class2", 80),
                new Tuple2<String, Integer>("class1", 89),
                new Tuple2<String, Integer>("class2", 87));

        JavaPairRDD<String, Integer> scores = jsc.parallelizePairs(scoreList);

        JavaPairRDD<String, Iterable<Integer>> groupScores = scores.groupByKey();

        groupScores.foreach((Tuple2<String, Iterable<Integer>> stringIterableTuple2) -> {
            System.out.println("class:" + stringIterableTuple2._1);

            for (Integer integer : stringIterableTuple2._2) {
                System.out.println(integer);
            }
            System.out.println("--------");
        });
        jsc.stop();
    }

    /**
     * 统计每个班级的总分
     */
    private static void reduceByKey() {
        SparkConf conf = new SparkConf().setAppName("filter").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> scoreList = Arrays.asList(
                (new Tuple2<>("class1", 80)),
                (new Tuple2<>("class2", 75)),
                (new Tuple2<>("class1", 88)),
                (new Tuple2<>("class2", 92))
        );
        JavaPairRDD<String,Integer> scores = sc.parallelizePairs(scoreList);
        /**
         * Function2传入3个参数，前两个为原始RDD中value的类型，第三个为reduce操作后返回值的类型
         */
        JavaPairRDD<String,Integer> sum = scores.reduceByKey(Integer::sum);
        sum.foreach((Tuple2<String, Integer> t2)->{
                System.out.println(t2._1+"的总分为"+t2._2);
        });
        sc.close();
    }

    private static void sortByKey(){
        SparkConf conf = new SparkConf().setAppName("filter").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<Integer, String>> scoreList = Arrays.asList(
                (new Tuple2<>(80,"zhangsan")),
                (new Tuple2<>(75,"lisi")),
                (new Tuple2<>(90,"wangwu")),
                (new Tuple2<>(84,"hop"))
        );
        JavaPairRDD<Integer,String> scores = sc.parallelizePairs(scoreList);
        JavaPairRDD<Integer,String> sorted = scores.sortByKey();
        //逆向排序
        //JavaPairRDD<Integer,String> sorted = scores.sortByKey(false);
        sorted.foreach((Tuple2<Integer,String> tp)->{
            System.out.println(tp._2+"\t"+tp._1);
        });
        sc.close();
    }

    private static void join(){
        SparkConf conf = new SparkConf().setAppName("13").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<Integer, String>> stuList = Arrays.asList(
                new Tuple2<>(1,"zhangsan"),
                new Tuple2<>(2,"lisi"),
                new Tuple2<>(3,"wangwu"),
                new Tuple2<>(4,"hop")
        );
        List<Tuple2<Integer, Integer>> stuScore = Arrays.asList(
                new Tuple2<>(1,100),
                new Tuple2<>(2,90),
                new Tuple2<>(3,70),
                new Tuple2<>(4,50)
        );
        JavaPairRDD<Integer,String> stu = sc.parallelizePairs(stuList);
        JavaPairRDD<Integer,Integer> scores = sc.parallelizePairs(stuScore);
        JavaPairRDD<Integer,Tuple2<String,Integer>> stuScores = stu.join(scores);
        stuScores.foreach((Tuple2<Integer, Tuple2<String, Integer>> tup)->{
           System.out.println("id:"+tup._1+" name:"+tup._2._1+" score:"+tup._2._2);
        });
        sc.close();
    }

    private static void coGroup(){
        SparkConf conf = new SparkConf().setAppName("13").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<Integer, String>> stuList = Arrays.asList(
                new Tuple2<>(1,"zhangsan"),
                new Tuple2<>(2,"lisi"),
                new Tuple2<>(3,"wangwu")
        );
        List<Tuple2<Integer, Integer>> stuScore = Arrays.asList(
                new Tuple2<>(1,88),
                new Tuple2<>(2,90),
                new Tuple2<>(3,70),
                new Tuple2<>(1,79),
                new Tuple2<>(2,70),
                new Tuple2<>(3,63)
        );
        JavaPairRDD<Integer, Tuple2<Iterable<String>, Iterable<Integer>>> cogroup = sc.parallelizePairs(stuList).cogroup(sc.parallelizePairs(stuScore));
        cogroup.foreach((Tuple2<Integer, Tuple2<Iterable<String>, Iterable<Integer>>> t)->{
                System.out.println("id:"+t._1+" name:"+t._2._1+" scores:"+t._2._2);
        });
        sc.close();
    }

}
