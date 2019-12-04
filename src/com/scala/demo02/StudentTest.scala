package com.scala.demo02

object StudentTest {
  def main(args: Array[String]): Unit = {
    val jack = new Student
    println(jack.name)
    jack.name = "zhangsan"
    println(jack.name)
  }
}
