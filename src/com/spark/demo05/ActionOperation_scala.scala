package com.spark.demo05

import org.apache.spark.{SparkConf, SparkContext}

object ActionOperation_scala {
  def main(args: Array[String]): Unit = {
    // reduce()
    //collect()
    //count()
    //take()
    //countByKey()
    countByValue()
  }

  def reduce(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(new SparkContext(conf).parallelize(arr).reduce(_ + _))
  }

  def collect(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val list = new SparkContext(conf).parallelize(arr).map(_ * 2).collect()
    for (i <- list) {
      println(i)
    }
  }

  def count(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(new SparkContext(conf).parallelize(arr).count())
  }

  def take(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val list = new SparkContext(conf).parallelize(arr).map(_ * 2).take(3)
    for (i <- list) {
      println(i)
    }
  }

  def countByKey(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(
      Tuple2("class1", "zhangsan"),
      Tuple2("class2", "lisi"),
      Tuple2("class1", "wangwu"),
      Tuple2("class2", "laoliu"),
      Tuple2("class1", "wangba")
    )
    new SparkContext(conf).parallelize(arr).countByKey().foreach(println)
  }

  def countByValue(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val arr = Array(
      Tuple2("zhangsan", "18"),
      Tuple2("lisi", "19"),
      Tuple2("wangwu", "17"),
      Tuple2("zhangsan", "18"),
      Tuple2("ddd", "17"),
      Tuple2("qqq", "19"),
      Tuple2("eee", "18"),
      Tuple2("xxx", "17")
    )
    new SparkContext(conf).parallelize(arr).countByValue().foreach(println)
  }
}
