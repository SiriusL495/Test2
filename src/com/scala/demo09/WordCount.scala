package com.scala.demo09

import scala.io.Source._

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = fromFile("C:\\Users\\SiriusL\\Desktop\\WordCount.txt")
      .getLines()
      .toList
      .flatMap(_.split(" "))
      .map(_ -> 1)
      .groupBy(_._1)
      .map(x => (x._1, x._2.size))
      .toList.sortBy(_._2)
      .map(x=>x._1+" "+x._2)
      .foreach(println)
   // val list = List(lines)
    //list.flatMap(_.split(" ")).flatMap(_.split("\n")).map(_->1).groupBy(_._1).mapValues(_.size).foreach(println)
    //lines.split(" ").map(_->1).map(_._2).sum
  }
}
