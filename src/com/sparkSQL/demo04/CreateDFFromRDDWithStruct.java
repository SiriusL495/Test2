package com.sparkSQL.demo04;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;
import java.util.List;

public class CreateDFFromRDDWithStruct {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("rddStruct")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> lineRDD = sc.textFile("./person.txt");
        /**
         * 把获得的数据转换为Row类型的RDD
         */
        JavaRDD<Row> rowRDD = lineRDD.map((String s)->{
            return RowFactory.create(
                    String.valueOf(s.split(",")[0]),
                    String.valueOf(s.split(",")[1]),
                    Integer.valueOf(s.split(",")[2])
            );
        });
        List<StructField> asList = Arrays.asList(
                DataTypes.createStructField("id",DataTypes.StringType,true),
                DataTypes.createStructField("name",DataTypes.StringType,true),
                DataTypes.createStructField("age",DataTypes.IntegerType,true)
        );
        StructType schema =  DataTypes.createStructType(asList);
        Dataset df = sqlContext.createDataFrame(rowRDD,schema);
        df.show();
        sc.stop();
    }
}
