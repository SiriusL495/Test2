package com.spark.Homework.Homework04

import org.apache.spark.{SparkConf, SparkContext}

object H4_scala {
  def main(args: Array[String]): Unit = {

  }

  def T1_1(): Unit = {
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

  def T1_2(): Unit = {
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

  def T2(): Unit = {
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

  def T3(): Unit = {
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

  def T4(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val stu = Array(
      Tuple2(1, "Spark"),
      Tuple2(2, "Maven"),
      Tuple2(3, "Hadoop")
    )
    val score = Array(
      Tuple2(1, 100),
      Tuple2(2, 95),
      Tuple2(3, 65)
    )
    val sc = new SparkContext(conf)
    sc.parallelize(stu)
      .join(sc.parallelize(score))
      .foreach(println)
  }

  def T5_1(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val stu = Array(
      Tuple2("hello", 3),
      Tuple2("hello", 2),
      Tuple2("world", 7),
      Tuple2("hello", 12),
      Tuple2("you", 9)
    )
    val score = Array(
      Tuple2("hello", 21),
      Tuple2("world", 24),
      Tuple2("hello", 25),
      Tuple2("you", 28)
    )
    sc.parallelize(stu)
      .join(sc.parallelize(score))
      .foreach(println)
  }

  def T5_2(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val stu = Array(
      Tuple2("hello", 3),
      Tuple2("hello", 2),
      Tuple2("world", 7),
      Tuple2("hello", 12),
      Tuple2("you", 9)
    )
    val score = Array(
      Tuple2("hello", 21),
      Tuple2("world", 24),
      Tuple2("hello", 25),
      Tuple2("you", 28)
    )
    sc.parallelize(stu)
      .cogroup(sc.parallelize(score))
      .foreach(println)
  }

}
