package com.scala.demo04

abstract class HelloAbstract(var message: String) {
  def hello(name: String): Unit = {
  }
}

class HelloAbstractImpl extends HelloAbstract("Hello") {
  override def hello(name: String): Unit = {
    println(message + "," + name)
  }
}