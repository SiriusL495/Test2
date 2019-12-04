package com.spark.Homework

import org.apache.spark.{SparkConf, SparkContext}

object Homework03 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("03").setMaster("local")
    new SparkContext(conf).textFile("C:\\Users\\SiriusL\\Desktop\\bbb.txt").flatMap(_.split("\\|")).sortBy(x => x).foreach(println)
  }
}
