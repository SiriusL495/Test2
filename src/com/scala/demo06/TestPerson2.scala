package com.scala.demo06

object TestPerson2 {
  def main(args: Array[String]): Unit = {
    val p2 = new Person2("lisi")
    val p = new Person
    p.name = "wangba"
    p2.makeFrends(p)
  }
}
