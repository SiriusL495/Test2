package com.scala.demo01

import scala.collection.mutable.ArrayBuffer

object TestArray {
  def main(args: Array[String]): Unit = {
    //    var a = new Array[Int](10)
    //    a(0)=11
    //    a(1)=13
    //    for(b<- a){
    //      println(b)
    //    }
    //    //直接使用Array创建数组，元素类型自行推断
    //    val b = Array("zhangsan","lisi")
    //    b.foreach(println)
    //
    //    var arr = Array[String]("123","456","789")
    //    arr(0) = "100"
    //    arr.foreach(println)

    //二维数组
    //    var arr3 = new Array[Array[String]](3)
    //    arr3(0)=Array("12","45","78")
    //    arr3(1)=Array("77","66","99")
    //    arr3(2)=Array("16","63","84")
    //    for(i <- arr3.indices){
    //      for(j <- arr3(i).indices){
    //        print(arr3(i)(j)+"\t")
    //      }
    //      println()
    //    }
    //
    //    arr3.foreach(arr =>{arr.foreach(println)})
    //    arr3.foreach(arr =>{arr.foreach(a => println(a))})
    //    arr3.foreach(arr =>{arr.foreach(a => print(a+"\t"));print("\n")})

    //    //arraybuffer相当于Java中的ArrayList
    //    val b = ArrayBuffer[Int]()
    //    //使用+=操作符，可以添加一个元素或者多个元素
    //    b += 1
    //    b += (2, 3, 4, 5, 6, 7, 8)
    //    //使用++操作符，可以添加其他集合中的所有元素
    //    b ++= Array(9, 10, 11, 12)
    //    b.foreach(println)
    val res = Array(5, 1, 3, 2, 4)
    val sum = res.sum
    val max = res.max
    val min = res.min
    println(res.mkString)
    println(res.mkString(","))
    println(res.mkString("<", ",", ">"))
    scala.util.Sorting.quickSort(res)
    println(res.mkString)
    println(res.mkString(","))
    println(res.mkString("<", ",", ">"))

    val res1 = Array(5, 1, 3, 2, 4)
    var res2 = new Array[Int](10)
    res2 = res1.clone()
    for(i <- res2.indices){
      print(res2(i))
    }
  }
}
