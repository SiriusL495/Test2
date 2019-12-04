package com.scala.Homework

import scala.io.StdIn

object Homework09_Scala {
  def main(args: Array[String]): Unit = {
//    T1
//    T2
//    T3
//    T4
  }

  def T1: Unit = {
    println("string:")
    val str = StdIn.readLine()
    //所有
    val s1 = str.toCharArray
    println("所有字符")
    println(str.toCharArray.sortBy(x => x).mkString(","))
    //去重
    val s2 = str.toSet.toArray
    println("去重后")
    println(str.toSet.toArray.sortBy(x => x).mkString(","))
    //重复的字符
    val s3 = s1.diff(s2).distinct
    println("重复的字符")
    println(s1.diff(s2).distinct.sortBy(x => x).mkString(","))
    //不重复的字符
    println("不重复的字符")
    println(s2.diff(s3).sortBy(x => x).mkString(","))
  }

  def T2: Unit = {
    List(new Student("zhangsan", "english", 90),
      new Student("lisi", "english", 70),
      new Student("wangwu", "english", 50)).foreach(x => x.print)
  }

  def T3: Unit = {
    val str3 = "123412132192314"
    str3.split("")
      .map(_ -> 1)
      .groupBy(_._1)
      .map(x => (x._1, x._2.length))
      .toList
      .sortBy(_._1)
      .foreach(x => println(x._1 + "出现了" + x._2 + "次"))
  }

  def T4: Unit = {
    println("string:")
    val str = StdIn.readLine()
    str.split(",")
      .map(_ -> 1)
      .groupBy(_._1)
      .map(x => (x._1, x._2.size))
      .toList.sortBy(_._2)
      .map(x=>x._1+" "+x._2)
      .foreach(println)
  }

  class Student(name: String, cname: String, grade: Double) {
    val sname = name
    val scname = cname
    val sgrade = grade

    def print: Unit = {
      println("name: " + sname + " class: " + scname + " grade: " + sgrade)
    }
  }

}


