package com.spark.demo09

import org.apache.spark.{SparkConf, SparkContext}

object Top3_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Top3").setMaster("local")
    println(new SparkContext(conf).textFile("./top3")
      .map(x => (x.toInt, x))
      .sortByKey(false)
      .map(_._1)
      .take(3)
      .mkString(","))
  }
}
