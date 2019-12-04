package com.sparkSQL.demo06

import java.util.Properties

import org.apache.spark.sql.{SaveMode, SparkSession}

import scala.collection.mutable

object CreateDFFromMySQL_scala {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("CreateDFFromMySQL_scala")
      .master("local")
      .getOrCreate()

    val person = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "person")
      .load()

    person.show()
    person.createOrReplaceTempView("person")

    val options = new mutable.HashMap[String,String]
    options+=("url"->"jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
    options+=("driver"->"com.mysql.cj.jdbc.Driver")
    options+=("user"->"root")
    options+=("password"->"123456")
    options+=("dbtable"->"score")
    val score = spark.read.format("jdbc").options(options).load()

    score.show()
    score.createOrReplaceTempView("score")

    val result = spark.sql("select person.id,person.name,score.score from person,score where person.name = score.name")
    result.show()

    val properties = new Properties()
    properties.setProperty("user","root")
    properties.setProperty("password","123456")
    result.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://localhost:3306/spark2?setUnicode=true&characterEncoding=utf8&serverTimezone=UTC","result",properties)
  }
}
