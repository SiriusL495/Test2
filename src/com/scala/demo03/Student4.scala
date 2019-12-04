package com.scala.demo03

import com.scala.demo03.Student4.getStu

class Student4 {
  println("123")
}

object Student4{
  def getStu = 2
  println("123 Obj")
  def main(args: Array[String]): Unit = {
    println(getStu)
  }
}
