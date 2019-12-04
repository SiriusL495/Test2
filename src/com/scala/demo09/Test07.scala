package com.scala.demo09

object Test07 {
  def main(args: Array[String]): Unit = {
    val lines = List("Hello lisi", "hello zhangsan", "zhangsan", "lisi", "zhangsan")
    //println(lines)
    //    val lines_1 = lines.map(_.split(" "))
    //    val lines_2 = lines_1.flatten
    //    println(lines_2)

    //结合map和flatten方法
    val words = lines.flatMap(_.split(" "))
    //将list中每一个元素映射成为元祖
    val wordToOne = words.map(_ -> 1)
    //分组:_._1中，第一个_表示元祖信息，后面的._1表示元祖中的第一个元素，即key值
    val group = wordToOne.groupBy(_._1)
    //x._1表示groupBy后的key，x._2表示groupBy后value值，是个list
    val grouped = group.map(x => (x._1, x._2.size))
    //将map转化成list
    val res = grouped.toList
    //排序
    val res_1 = res.sortBy(_._2).reverse
    //println(res_1.reverse)

    //    val finalRes = lines.flatMap(_.split(" ")).map(_->1).groupBy(_._1).map(x=>(x._1,x._2.size)).toList.sortBy(_._2).reverse
    //    finalRes.foreach(println)

    //lines.flatMap(_.split(" ")).map(_ -> 1).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2).mkString.foreach(println)

    lines
      .flatMap(_.split(" "))
      .map(_ -> 1)
      .groupBy(_._1)
      .map(x => (x._1, x._2.size))
      .foreach(x=>println(x._1+" "+x._2))

    lines
      .flatMap(_.split(" "))
      .map(_ -> 1)
      .groupBy(_._1)
      .map(x => (x._1, x._2.size))
      .toList.sortBy(_._2)
      .map(x=>x._1+" "+x._2)
      .foreach(println)

  }
}
