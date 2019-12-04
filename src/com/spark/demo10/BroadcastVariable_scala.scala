package com.spark.demo10

import org.apache.spark.{SparkConf, SparkContext}

object BroadcastVariable_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("BroadcastVariable_scala")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val factor = 3
    val arr = Array(1,2,3,4,5)
    val factorBroadcast = sc.broadcast(factor)
    sc.parallelize(arr)
      .map(_*factorBroadcast.value)
      .foreach(println)
  }
}
