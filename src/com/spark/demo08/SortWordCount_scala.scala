package com.spark.demo08

import org.apache.spark.{SparkConf, SparkContext}

object SortWordCount_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SortWordCount").setMaster("local")
    new SparkContext(conf)
      .textFile("./words")
      .flatMap(_.split(" "))
      .map(_->1)
      .reduceByKey(_+_)
      .sortBy(_._2,false)
      .foreach(x=>println(x._1+" 出现了 "+x._2+" 次"))
  }

}
