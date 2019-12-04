package com.scala.demo02

object HelloWorld2{
  def main(args: Array[String]): Unit = {
    val helloWorld2 = new HelloWorld
    helloWorld2.sayHello()
    println("helloworld="+helloWorld2.getName)
  }
}

class HelloWorld {
  private var name = "Bill"
  def sayHello(){println("Hello,"+name)}
  def getName = name

}
