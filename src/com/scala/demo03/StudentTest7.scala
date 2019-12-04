package com.scala.demo03

object StudentTest7 {
  def main(args: Array[String]): Unit = {
    val s1 = new Student7
    val c1 = s1.getStudent("zhangsan")
    s1.students += c1

    println("23" )

    val s2 = new Student7
    val c2 = s2.getStudent("lisi")
    s2.students += c2


  }
}
