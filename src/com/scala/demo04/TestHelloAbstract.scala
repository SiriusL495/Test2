package com.scala.demo04

object TestHelloAbstract {
  def main(args: Array[String]): Unit = {
    val hello = new HelloAbstractImpl
    hello.hello("123")
  }
}
