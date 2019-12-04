package com.scala.demo09

object Test01 {

  var factor = 3
  val mult = (i:Int)=>i*factor

  def main(args: Array[String]): Unit = {
//    println("multiplier(1) value="+mult(1))
//    println("multiplier(2) value="+mult(2))
//    println("multiplier(3) value="+mult(3))
    val t1 = new Test01
//    println(t1.sum(1,1))
//    println(t1.sum2(1)(2))
//    println(t1.sum3(1)(4))

    println(t1.greeting("zhangsan"))

  }
}

class Test01{
  def sum(a:Int,b:Int)= a+b
  def sum2(a:Int) = (b:Int) =>a+b
  def sum3(a:Int)(b:Int) = a+b

  def greeting(name:String): String ={
    def sayHello(name:String):String={
      "Hello,"+name
    }
    sayHello(name)
  }

}