package com.scala.demo02

object StudentTest2 {
  def main(args: Array[String]): Unit = {
    val jack = new Student2
    println(jack.name)
    jack.name="lisi"
    println(jack.name)
  }
}
