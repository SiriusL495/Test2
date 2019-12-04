package com.spark.demo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    /*val conf = new SparkConf().setAppName("ScalaWordCountLocal").setMaster("local")
    val context = new SparkContext(conf)
    //文本RDD
    val lines: RDD[String] = context.textFile("./words")
    //散列RDD
    val words: RDD[String] = lines.flatMap(_.split(" "))
    //映射RDD
    val pairwords: RDD[(String, Int)] = words.map(word => new Tuple2(word, 1))
    //根据键聚合
    val res: RDD[(String, Int)] = pairwords.reduceByKey(_ + _)
    res.foreach(x => println(x._1 + " 产生了 " + x._2 + " 次"))
    context.stop()*/

    val conf = new SparkConf().setAppName("ScalaWordCountLocal").setMaster("local")
    new SparkContext(conf).textFile("./words")
      .flatMap(_.split(" "))
      .map(_ -> 1)
      .reduceByKey(_ + _)
      .foreach(x => println(x._1 + " 产生了 " + x._2 + " 次"))



    //    val resRDD1 = context.textFile("./words")
    //      .flatMap(_.split(" "))
    //      .map(_ -> 1)
    //      .reduceByKey(_ + _)
    //      .foreach(x => println(x._1 + " 产生了 " + x._2 + " 次"))

  }
}
