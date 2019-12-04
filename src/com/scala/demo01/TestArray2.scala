package com.scala.demo01

import scala.collection.mutable.ArrayBuffer

object TestArray2 {
  def main(args: Array[String]): Unit = {
    //对Array进行转换，获取的还是Array
    val a = Array(1, 2, 3, 4, 5)
    val a2 = for (i <- a) yield i * i
    a2.foreach(println)
    println("-------------------------------------")
    //对ArrayBuffer进行转换，获取的还是ArrayBuffer
    var b = ArrayBuffer[Int]()
    b += (1, 2, 3, 4, 5)
    val b2 = for (ele <- b) yield ele * ele
    b2.foreach(println)
    println("-------------------------------------")
    //if守卫
    val a3 = for (ele <- a if ele % 2 == 0) yield ele * ele
    a3.foreach(println)
    println("-------------------------------------")
    val a4 = a.filter(_ % 2 ==0).map(2* _)
    a4.foreach(println)
    println("-------------------------------------")
    val c = Array(1,2,3,4,5,-1,-8,-9)
    val c1 = c.filter(_ <0)
    c1.foreach(print)
  }
}
