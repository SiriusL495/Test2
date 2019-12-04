package com.scala.demo09

object Test05 {
  def main(args: Array[String]): Unit = {
    //创建
    val set1 = Set(1, 2, 3, 4, 4, 4)
    val set2 = Set(1, 2, 5)

    //遍历
    set1.foreach(println)
    for(i<-set1){
      println(i)
    }

    //交集
    val set3 = set1.intersect(set2)
    set3.foreach(println)

    val set4 = set1.&(set2)
    set4.foreach(println)

    //差集
    set1.diff(set2).foreach(println)
    set1.&~(set2).foreach(println)

    //子集
    val set5 = set1.subsetOf(set2)//返回boolean
    println(set5)

    //最大最小值
    println(set1.max)
    println(set1.min)

    //转成数组
    set1.toArray.foreach(println)
    set1.toList.foreach(println)

    //mkString
    println(set1.mkString(","))
  }
}
