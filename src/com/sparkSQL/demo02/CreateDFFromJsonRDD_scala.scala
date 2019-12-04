package com.sparkSQL.demo02

import org.apache.spark.{SparkConf, SparkContext, sql}
import org.apache.spark.sql.{SQLContext, SparkSession}

object CreateDFFromJsonRDD_scala {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession
      .builder()
      .appName("CreateDFFromJsonRDD")
      .master("local[*]")
      .getOrCreate()
    val sc = SparkContext.getOrCreate()

    val name = Array(
      "{\"name\":\"zhangsan\",\"age\":\"18\"}",
      "{\"name\":\"lisi\",\"age\":\"19\"}",
      "{\"name\":\"wangwu\",\"age\":\"17\"}"
    )
    val score = Array(
      "{\"name\":\"zhangsan\",\"score\":\"97\"}",
      "{\"name\":\"lisi\",\"score\":\"68\"}",
      "{\"name\":\"wangwu\",\"score\":\"85\"}"
    )
    val namedf = ss.read.json(sc.parallelize(name))
    val scoredf = ss.read.json(sc.parallelize(score))
    namedf.join(scoredf,namedf.col("name").equalTo(scoredf.col("name")))
      .select(namedf.col("name"),namedf.col("age"),scoredf.col("score")).show()
  }
}
