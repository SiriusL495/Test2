package com.spark.Homework

import org.apache.spark.{SparkConf, SparkContext}

object Homework05 {
  def main(args: Array[String]): Unit = {
    T4()
  }

  def T1(): Unit = {
    val conf = new SparkConf().setAppName("T1").setMaster("local")
    new SparkContext(conf).parallelize(List((3, "gun"), (3, "yak"), (5, "mouse"), (3, "dog")), 2).countByKey().foreach(println)
  }

  def T2(): Unit = {
    val conf = new SparkConf().setAppName("T2").setMaster("local")
    println(new SparkContext(conf).parallelize(List("Gnu", "Cat", "Rat", "Dog", "Gnu", "Rat"), 2).collect())
  }

  def T3(): Unit = {
    val conf = new SparkConf().setAppName("T3").setMaster("local")
    println(new SparkContext(conf).parallelize(List((3, "gun"), (3, "yak"), (5, "mouse"), (3, "dog")), 2).first())
  }

  def T4(): Unit = {
    val conf = new SparkConf().setAppName("T4").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(5, 6, 4, 3))
    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
    //并集
    println(rdd1.union(rdd2).collect().mkString(","))
    //交集
    println(rdd1.intersection(rdd2).collect().mkString(","))
    //去重
    println(rdd1.union(rdd2).distinct().collect().mkString(","))
    //左连接
    rdd1.zipWithIndex().leftOuterJoin(rdd2.zipWithIndex()).foreach(println)
    //右连接
    rdd1.zipWithIndex().rightOuterJoin(rdd2.zipWithIndex()).foreach(println)
  }
}
