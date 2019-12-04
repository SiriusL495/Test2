package com.scala.Homework

object Homework11_Scala {
  def main(args: Array[String]): Unit = {
    println(factorial(5))
  }

  def factorial(i: Int): Int = {
    if (i == 0) {
      1
    }
    else {
      i * factorial(i - 1)
    }
  }

}
