package com.spark.demo03

import org.apache.spark.{SparkConf, SparkContext}

object ParallelizedCollection_Scala {
  def main(args: Array[String]): Unit = {
    p3
  }
  def p1: Unit ={
    val conf = new SparkConf().setAppName("123").setMaster("local")
    val arr = Array(1,2,3,4,5,6,7,8,9,10)
    println(new SparkContext(conf).parallelize(arr).reduce(_ + _))
  }
  def p2: Unit ={
    val conf = new SparkConf().setAppName("456").setMaster("local")
    println(new SparkContext(conf).textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt").flatMap(_.split("")).count())
  }
  def p3: Unit ={
    val conf = new SparkConf().setAppName("456").setMaster("local")
    println(new SparkContext(conf).textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt").map(_.length).reduce(_+_))
  }
}
