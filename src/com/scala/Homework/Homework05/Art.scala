package com.scala.Homework.Homework05

class Art {
  def Art(): Unit = {
    println("Art constructor")
  }
}

class Drawing extends Art {
  def Drawing(): Unit = {
    println("Drawing constructor")
  }
}

class Cartoon extends Drawing {
  def Cartoon(): Unit = {
    println("Cartoon constructor")
  }
}
