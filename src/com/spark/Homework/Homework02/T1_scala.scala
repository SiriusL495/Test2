package com.spark.Homework.Homework02

import org.apache.spark.{SparkConf, SparkContext}

object T1_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("T1").setMaster("local")
    val arr = Array(1,2,3,4,5,6,7,8,9)
    new SparkContext(conf).parallelize(arr).filter(_%2==0).map(_*3).foreach(println)
  }
}
