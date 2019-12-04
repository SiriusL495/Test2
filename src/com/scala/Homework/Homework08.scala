package com.scala.Homework

import scala.collection.mutable
import scala.io.Source.fromFile

object Homework08 {
  def main(args: Array[String]): Unit = {
    //第一题
    println(List(1,2,3,4,5).reverse)

    //第二题
    val a = List(1,2,3,4,5).map(_*10)

    //第三题
    println(List(1,2,3,4,5).filter(_%2==0))

    //第四题
    println(List(List(1,2,3),List(4,5,6),List(7,8,9)).flatten)

    //第五题
    println(mutable.Set(1,2,3)-=3)
    println(mutable.Set(1,2,3,4)--Set(1,2))

    //第六题
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

  }
}
