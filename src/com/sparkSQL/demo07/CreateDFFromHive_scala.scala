package com.sparkSQL.demo07

import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.hive.HiveContext

object CreateDFFromHive_scala {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("hive")
      .getOrCreate()
    spark.sql("use spark")
    spark.sql("drop table if exists studentinfo")
    spark.sql("create table if not exists studentinfo (name string,age int) row format delimited fields terminated by '\t'")
    spark.sql("load data local inpath '/home/homework/studentinfo' into table studentinfo")

    spark.sql("drop table if exists studentscore")
    spark.sql("create table if not exists studentscore (name string,age int) row format delimited fields terminated by '\t'")
    spark.sql("load data local inpath '/home/homework/studentscore' into table studentscore")

    val df = spark.sql("select stu.name,stu.age,sc.score from studentinfo stu join studentscore sc on stu.name = sc.name where sc.score > 80")
    spark.sql("drop table if exists goodstudents")
    df.write.mode(SaveMode.Overwrite).saveAsTable("goodstudents")

  }
}
