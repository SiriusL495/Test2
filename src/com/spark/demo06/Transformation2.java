package com.spark.demo06;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Transformation2 {
    public static void main(String[] args) {
        //zip2();
        //leftOuterJoin();
        //rightOuterJoin();
        //fullOuterJoin();
        //union();
        //intersection();
        //subtract();
        mapPartition();
    }

    /**
     * 将每个元素与其下标压缩成k,v格式的RDD
     */
    private static void zip2() {
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<String, String> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>("class1", "zhangsan"),
                        new Tuple2<>("class2", "lisi"),
                        new Tuple2<>("class1", "wangwu"),
                        new Tuple2<>("class2", "laoliu"),
                        new Tuple2<>("class1", "goudan")
                )
        );
        JavaPairRDD<Tuple2<String, String>, Long> zip = rdd1.zipWithIndex();
        zip.foreach((Tuple2<Tuple2<String, String>, Long> t) -> {
            System.out.println(t);
        });

        /**
         * zip将两个RDD压缩成一个k,v格式的RDD
         * 两个RDD中每个分区的数据要一致
         */
        JavaPairRDD<String, Integer> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>("class1", 1),
                        new Tuple2<>("class2", 3),
                        new Tuple2<>("class1", 5),
                        new Tuple2<>("class2", 2),
                        new Tuple2<>("class1", 4)
                )
        );
        JavaPairRDD<Tuple2<String, String>, Tuple2<String, Integer>> zip2 = rdd1.zip(rdd2);
        zip2.foreach((Tuple2<Tuple2<String, String>, Tuple2<String, Integer>> t) -> {
            System.out.println(t);
        });
    }

    /**
     * leftOuterJoin:左所有元素与右连接
     * rightOutJoin：右所有元素与左连接
     * fullOuterJoin全连接
     * Union：直接连接
     * intersection：只保留a和b都有的
     * subtract:在a中去掉a和b都有的
     */

    private static void leftOuterJoin(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<String, String> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>("class1", "zhangsan"),
                        new Tuple2<>("class2", "lisi"),
                        new Tuple2<>("class3", "wangwu")
                )
        );
        JavaPairRDD<String, Integer> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>("class1", 1),
                        new Tuple2<>("class2", 3),
                        new Tuple2<>("class3", 5),
                        new Tuple2<>("class4", 2),
                        new Tuple2<>("class5", 4)
                )
        );
        JavaPairRDD<String, Tuple2<String, Optional<Integer>>> rlr = rdd1.leftOuterJoin(rdd2);
        rlr.foreach((Tuple2<String, Tuple2<String, Optional<Integer>>> t)->{
            System.out.println(t._1+" "+t._2._1+" "+t._2._2.get());
        });
    }

    private static void rightOuterJoin(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, String> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, "zhangsan"),
                        new Tuple2<>(2, "lisi"),
                        new Tuple2<>(3, "wangwu")

                )
        );
        JavaPairRDD<Integer, String> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, "1"),
                        new Tuple2<>(2, "3"),
                        new Tuple2<>(3, "5"),
                        new Tuple2<>(4 ,"2"),
                        new Tuple2<>(5, "4")
                )
        );
        JavaPairRDD<Integer, Tuple2<Optional<String>, String>> rlr = rdd1.rightOuterJoin(rdd2);
        rlr.foreach((Tuple2<Integer, Tuple2<Optional<String>, String>> t)->{
            System.out.println(t._1+" "+t._2._1+" "+t._2._2);
        });
    }

    private static void fullOuterJoin(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, String> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, "zhangsan"),
                        new Tuple2<>(2, "lisi"),
                        new Tuple2<>(3, "wangwu")

                )
        );
        JavaPairRDD<Integer, String> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, "1"),
                        new Tuple2<>(2, "3"),
                        new Tuple2<>(3, "5"),
                        new Tuple2<>(4 ,"2"),
                        new Tuple2<>(5, "4")
                )
        );
        JavaPairRDD<Integer, Tuple2<Optional<String>, Optional<String>>> rlr = rdd1.fullOuterJoin(rdd2);
        rlr.foreach((Tuple2<Integer, Tuple2<Optional<String>, Optional<String>>> t)->{
            System.out.println(t._1+" "+t._2._1+" "+t._2._2);
        });
    }

    //全集
    private static void union(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, String> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(7, "zhangsan"),
                        new Tuple2<>(8, "lisi"),
                        new Tuple2<>(2, "wangwu"),
                        new Tuple2<>(5, "wangwu")

                )
        );
        JavaPairRDD<Integer, String> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, "1"),
                        new Tuple2<>(2, "3"),
                        new Tuple2<>(3, "5"),
                        new Tuple2<>(4 ,"2"),
                        new Tuple2<>(5, "4")
                )
        );
        JavaPairRDD<Integer,String> rur = rdd1.union(rdd2);
        rur.foreach((Tuple2<Integer, String> t)->{
            System.out.println(t);
        });
    }
    //交集
    private static void intersection(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, Integer> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(7, 7),
                        new Tuple2<>(8, 8),
                        new Tuple2<>(2, 2),
                        new Tuple2<>(5, 5)

                )
        );
        JavaPairRDD<Integer, Integer> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, 1),
                        new Tuple2<>(2, 2),
                        new Tuple2<>(3, 3),
                        new Tuple2<>(4 ,4),
                        new Tuple2<>(5, 5)
                )
        );
        JavaPairRDD<Integer,Integer> rur = rdd1.intersection(rdd2);
        rur.foreach((Tuple2<Integer, Integer> t)->{
            System.out.println(t);
        });
    }
    //补集
    private static void subtract(){
        SparkConf conf = new SparkConf().setAppName("countByValue").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, Integer> rdd1 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(7, 7),
                        new Tuple2<>(8, 8),
                        new Tuple2<>(2, 2),
                        new Tuple2<>(5, 5)

                )
        );
        JavaPairRDD<Integer, Integer> rdd2 = sc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<>(1, 1),
                        new Tuple2<>(2, 2),
                        new Tuple2<>(3, 3),
                        new Tuple2<>(4 ,4),
                        new Tuple2<>(5, 5)
                )
        );
        JavaPairRDD<Integer,Integer> rur = rdd1.subtract(rdd2);
        rur.foreach((Tuple2<Integer, Integer> t)->{
            System.out.println(t);
        });
    }

    /**
     * mapPartition和mapPartitionWithIndex
     * map一条条处理数据，mapPartition一个个分区处理数据
     */
    private static void mapPartition(){
        SparkConf conf = new SparkConf().setAppName("mapPartition").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd1 = sc.parallelize(Arrays.asList(
                "class1",
                "class2",
                "class3",
                "class4",
                "class5",
                "class6",
                "class7",
                "class8",
                "class9",
                "class10",
                "class11",
                "class12",
                "class13"
        ),3);
        JavaRDD<String>mpwi = rdd1.mapPartitionsWithIndex((Integer index, Iterator<String> iterator)->{
            List<String> list = new ArrayList<String>();
            while(iterator.hasNext()){
                String one = iterator.next();
                list.add("rdd1.partition index="+index+",value="+one);
            }
            return list.iterator();
        },true);
        /**
         * coalesce和repartition一样，可以对RDD进行分区，可以增加或减少分区
         * shuffle设置成为false表示不产生shuffle。
         * repartition是有shuffle算子，可以对RDD重新分区
         * repartition等价于coalesce(partitionNum,true)
         */
        JavaRDD<String> rdd2 = mpwi.coalesce(4,false);
        System.out.println("rdd2 partition length = "+rdd2.partitions().size());
        JavaRDD<String> mpwi2 = rdd2.mapPartitionsWithIndex((Integer index, Iterator<String> iterator)->{
            List<String> list = new ArrayList<String>();
            while(iterator.hasNext()){
                String one = iterator.next();
                list.add("rdd2.partition index="+index+",value="+one);
            }
            return list.iterator();
        },true);
        List<String> collect = mpwi2.collect();
        for(String s:collect){
            System.out.println(s);
        }
        sc.close();
    }
}
