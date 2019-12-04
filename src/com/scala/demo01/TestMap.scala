package com.scala.demo01

import scala.collection.mutable
import scala.collection.immutable

object TestMap {
  def main(args: Array[String]): Unit = {
    //创建一个不可变的Map
    val ages = Map("Leo" -> 20, "Jackal" -> 28, "Sam" -> 40)
    println(ages("Sam"))

    //创建可变Map
    val age2 = mutable.Map("Leo" -> 20, "Jackal" -> 28, "Sam" -> 40)
    age2("Sam") = 31

    //另一种方式定义Map
    val age3 = Map(("Leo", 30), ("Jack", 40), ("Sam", 50))

    //创建空Map
    val age4 = new mutable.HashMap[String, Int]

    val leoAge = if (ages.contains("Leo")) ages("Leo") else 0
    println(leoAge)
    val leoAge2 = ages.getOrElse("Leo", 0)
    println(leoAge2)

    //移除可变Map的元素
    age2 -= "Sam"
    //移除不可变Map的元素
    val age5 = ages - "Leo"

    //添加可变Map元素
    age2 += ("zhangsan" -> 20, "lisi" -> 30)
    //添加不可变Map元素
    val age6 = ages + ("zhangsan" -> 20, "lisi" -> 30)

    //遍历Map
    for ((key, value) <- ages) println(key + " " + value)
    //遍历Map的Key
    for(key <- ages.keySet) println(key)
    //遍历Map的Value
    for(value <- ages.values) println(value)

    //根据一个map生成一个map
    val age7 = for((key,value) <- ages) yield (value,key)
    age7.foreach(println)


  }
}
