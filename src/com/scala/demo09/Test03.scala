package com.scala.demo09

import scala.collection.mutable

object Test03 {
  def main(args: Array[String]): Unit = {
    var s = Set(1, 3, 4)
    s = s + 1
    s = s + 2
    s = s + 3
    s = s + 4
    //set中元素不能重复
    s.foreach(println)

    //乱序
    val hashSet = new mutable.HashSet[Int]()
    hashSet+=1
    hashSet+=5
    hashSet+=3
    hashSet.foreach(println)

    //LinkedHashSet 顺序
    val linkedHashSet = scala.collection.mutable.LinkedHashSet[Int]()
    linkedHashSet += 1
    linkedHashSet += 2
    linkedHashSet += 6
    linkedHashSet += 4
    linkedHashSet.foreach(println)

    //SortedSet会根据key进行排序
    val sortedSet = scala.collection.mutable.SortedSet("o","a","b")
    sortedSet.foreach(println)

  }
}
