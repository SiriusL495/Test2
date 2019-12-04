package com.scala.demo09

object Test04 {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5)
    list.foreach(print)
    println()

    //filter
    val list1 = list.filter { x => x > 3 }
    list1.foreach(print)
    println()

    //count
    val value = list.count{x =>x>2}
    println(value)

    val nameList = List("hello a","hello b","hello c")
    val mapResult:List[Array[String]] = nameList.map(x=>x.split(" "))
    mapResult.foreach(x=>x.foreach(println))

    //flatMap
    val flatMap:List[String] = nameList.flatMap(x=>x.split(" "))
    flatMap.foreach(println)

  }
}
