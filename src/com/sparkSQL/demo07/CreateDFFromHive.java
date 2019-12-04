package com.sparkSQL.demo07;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.hive.HiveContext;

public class CreateDFFromHive {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("hive");
        JavaSparkContext sc = new JavaSparkContext(conf);
        HiveContext hiveContext = new HiveContext(sc);

        hiveContext.sql("use spark");
        hiveContext.sql("drop table if exists studentinfo");
        hiveContext.sql("create table if not exists studentinfo (name string,age int) row format delimited fields terminated by '\t' ");
        hiveContext.sql("load data local inpath '/home/homework/studentinfo' into table studentinfo");

        hiveContext.sql("drop table if exists studentscore");
        hiveContext.sql("create table if not exists studentscore (name string,score int) row format delimited fields terminated by '\t' ");
        hiveContext.sql("load data local inpath '/home/homework/studentscore' into table studentscore");

        /**
         * 查询表生成DataFrame
         */
        Dataset studentDF = hiveContext.sql("select stu.name,stu.age,sc.score from studentinfo stu join studentscore sc on stu.name = sc.name where sc.score > 80");
        studentDF.registerTempTable("6VStudent");
        Dataset result = hiveContext.sql("select * from 6VStudent");
        result.show();

        /**
         * 将结果保存到hive
         */
        hiveContext.sql("drop table if not exists studentinfos");
        studentDF.write().mode(SaveMode.Overwrite).saveAsTable("studentinfos");
        Dataset table = hiveContext.table("studentinfos");
        Row[] goodStudents = (Row[]) table.collect();
        for (Row goodStudent : goodStudents) {
            System.out.println(goodStudent);
        }
        sc.stop();
    }
}
