package com.scala.Homework

object Homework07 {
  def main(args: Array[String]): Unit = {

    //第一题
    // println(Array(1,7,9,2,5,8).reduceLeft(_ max _))

    //第二题
    // println((1 to 5).reduceLeft(_ * _))

    //第三题
    val h7 = new Homework07
    println(h7.largest(x => 10 * x - x * x, (1 to 9)))

    //第四题
    h7.swap(Array(9, 8, 7, 6, 5))
  }
}

class Homework07 {

  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(a => fun(a)).max
  }

  def swap(a: Array[Int]): Unit = {
    if (a.length > 2) {
      a match {
        case Array(a, b, c@_*) => println((Array(b, a) ++ c).mkString(","))
      }
    } else {
      println("数组长度应大于2")
    }

  }

}