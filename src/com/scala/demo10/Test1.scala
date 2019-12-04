package com.scala.demo10

object Test1 {
  def main(args: Array[String]): Unit = {
    val arr = scala.collection.mutable.ArrayBuffer(1, 2, 3, 4)
    //println(arr.exists(_%3==0))
    //arr.filter(_%2==0)
    //arr.filterNot(_%2==0).foreach(println)

    //取满足条件的元素，直到不满足为止
    println("takeWhile====================")
    arr.takeWhile(_ < 3).foreach(println)
    //取前n个元素
    println("take====================")
    arr.take(3).foreach(println)
    //保留不满足条件的元素
    println("dropWhile====================")
    arr.dropWhile(_ % 2 == 1).foreach(println)

    //1-2-3-4
    println("reduceLeft===================")
    println(List(1, 2, 3, 4).reduceLeft(_ - _))
    //给一个起始元素
    println("foldLeft=====================")
    println(List(1, 2, 3, 4).foldLeft(15)(_ - _))

  }
}
