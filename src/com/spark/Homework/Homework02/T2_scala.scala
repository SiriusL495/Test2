package com.spark.Homework.Homework02

import org.apache.spark.{SparkConf, SparkContext}

object T2_scala {
  def main(args: Array[String]): Unit = {
    Q7
  }

  def Q1: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q1")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c.toInt, d, e, f.toInt) }
      .filter(_._5 == "语文")
      .groupBy(_._2)
      .count()
    println(list)
  }

  def Q2: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c.toInt, d, e, f.toInt) }
      .filter(_._5 == "语文")
      .filter(_._3 > 20)
      .groupBy(_._2)
      .count()
    println(list)
  }

  def Q3: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c.toInt, d, e, f.toInt) }
      .filter(_._4 == "女")
      .groupBy(_._2)
      .count()
    println(list)
  }

  def Q4: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c, d, e, f) }
      .filter(_._5 == "数学")
      .map { case (a, b, c, d, e, f) => (a, (f.toInt, 1)) }
      .reduceByKey((a, b) => (a._1 + b._1, a._2 + b._2))
      .map(x => (x._1, x._2._1 / x._2._2))
      .foreach(x => println(x._1 + "班的数学平均分为：" + x._2))
  }

  def Q5: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c, d, e, f) }
      .filter(_._1 == "1")
      .filter(_._5 == "语文")
      .map { case (a, b, c, d, e, f) => (a, (f.toInt, 1)) }
      .reduceByKey((a, b) => (a._1 + b._1, a._2 + b._2))
      .map(x => (x._1, x._2._1 / x._2._2))
      .foreach(x => println(x._1 + "班的语文平均分为：" + x._2))
  }

  def Q6: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (a, b, c, d, e, f) }
      .filter(_._5 == "英语")
      .map(_._6)
      .max()
    println(list)
  }

  def Q7: Unit = {
    val conf = new SparkConf()
      .setAppName("T2_Q2")
      .setMaster("local")
    val list = new SparkContext(conf)
      .textFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt")
      .map(_.split("\t").toList)
      .map { case List(a, b, c, d, e, f) => (b, f.toInt) }
      .reduceByKey(_ + _)
      .filter(_._2 > 190)
      .foreach(x => println(x._1 + "能上二本，总分为：" + x._2))
  }
}
