package com.spark.demo02

import org.apache.spark.{SparkConf, SparkContext}

object TransformationOperation_scala {
  def main(args: Array[String]): Unit = {
    //map()
    //filter()
    //flatMap()
    //groupByKey()
    //reduceByKey()
    //sortByKey()
    //join()
    coGroup()
  }

  def map(): Unit = {
    val conf = new SparkConf()
      .setAppName("*2")
      .setMaster("local")
    val arr = Array(1, 2, 3, 4, 5)
    new SparkContext(conf)
      .parallelize(arr)
      .map(_ * 2)
      .foreach(print)
  }

  def filter(): Unit = {
    val conf = new SparkConf()
      .setAppName("*2")
      .setMaster("local")
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    new SparkContext(conf)
      .parallelize(arr)
      .filter(_ % 2 == 0)
      .foreach(print)
  }

  def flatMap(): Unit = {
    val conf = new SparkConf()
      .setAppName("*2")
      .setMaster("local")
    val arr = Array("hello you", "hello me", "hello everybody")
    new SparkContext(conf)
      .parallelize(arr)
      .flatMap(_.split(" "))
      .foreach(println)
  }

  def groupByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("*2")
      .setMaster("local")
    val arr = Array(new Tuple2("class1", 90),
      Tuple2("class2", 80),
      Tuple2("class1", 89),
      Tuple2("class2", 87))
    new SparkContext(conf)
      .parallelize(arr)
      .groupByKey()
      .foreach(x => {
        println(x._1);
        x._2.foreach(println)
      })
  }

  def reduceByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val arr = Array(
      Tuple2("class1", 90),
      Tuple2("class2", 80),
      Tuple2("class1", 89),
      Tuple2("class2", 87)
    )
    new SparkContext(conf)
      .parallelize(arr)
      .reduceByKey(_ + _)
      .foreach(x => println(x._1 + "的总分为：" + x._2))
  }

  def sortByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val arr = Array(
      Tuple2(80, "zhangsan"),
      Tuple2(75, "lisi"),
      Tuple2(92, "wangwu"),
      Tuple2(63, "hop")
    )
    new SparkContext(conf)
      .parallelize(arr)
      .sortByKey()
      .foreach(x => println(x._2 + "\t" + x._1))
  }

  def join(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val stu = Array(
      Tuple2(1, "zhangsan"),
      Tuple2(2, "lisi"),
      Tuple2(3, "wangwu"),
      Tuple2(4, "hop")
    )
    val score = Array(
      Tuple2(1, 100),
      Tuple2(2, 90),
      Tuple2(3, 70),
      Tuple2(4, 50)
    )
    val sc = new SparkContext(conf)
    sc.parallelize(stu)
      .join(sc.parallelize(score))
      .foreach(x => println("id: " + x._1 + " name: " + x._2._1 + " score: " + x._2._2))
  }

  def coGroup(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val stu = Array(
      Tuple2(1, "zhangsan"),
      Tuple2(2, "lisi"),
      Tuple2(3, "wangwu")
    )
    val score = Array(
      Tuple2(1, 88),
      Tuple2(2, 90),
      Tuple2(3, 70),
      Tuple2(1, 79),
      Tuple2(2, 70),
      Tuple2(3, 63)
    )
    sc.parallelize(stu)
      .cogroup(sc.parallelize(score))
      .foreach(x => println(
        "id:" + x._1 + " name:" + x._2._1.mkString(",") + " scores:" + x._2._2.mkString(",")
      ))
  }

}
