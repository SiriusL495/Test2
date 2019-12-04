package com.scala.demo06

class Person2(val name:String) extends Logger {
  def makeFrends(p:Person): Unit ={
    println("I'm "+name+" and fk "+p.name)
    log("nope")
  }
}
