package com.spark.demo08;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class SecondarySort {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("SecondarySort")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("./testSecond");
        JavaPairRDD<SecondarySortKey, String> pairs = lines.mapToPair(new PairFunction<String, SecondarySortKey, String>() {
            @Override
            public Tuple2<SecondarySortKey, String> call(String line) throws Exception {
                String[] lineSplit = line.split(" ");
                SecondarySortKey key = new SecondarySortKey(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]));
                return new Tuple2<SecondarySortKey, String>(key, line);
            }
        });
        JavaPairRDD<SecondarySortKey, String> sortedPairs = pairs.sortByKey();
        JavaRDD<String> sortedLines = sortedPairs.map(new Function<Tuple2<SecondarySortKey, String>, String>() {
            @Override
            public String call(Tuple2<SecondarySortKey, String> v1) throws Exception {
                return v1._2;
            }
        });
        sortedLines.foreach((String s)->{
            System.out.println(s);
        });
        sc.close();
    }
}
