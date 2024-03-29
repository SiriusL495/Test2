package com.scala.demo12

class Implicit(a:A){
  def Test: Unit ={
    println("Implicit")
  }
}

class A{

}

object Implicit {
  //隐式转换
  implicit def a2Implicit(a:A) = new Implicit(a)

  def ImplicitMethod(implicit name:String): Unit ={
    println(name)
  }

  //隐式类
  implicit class Calculate(x:String){
    def add(a:Int):Int= a+1
  }

  def main(args: Array[String]): Unit = {
    //隐式转换
    val a = new A
    a.Test
    //隐式参数
    implicit val name = "hank"
    ImplicitMethod
    ImplicitMethod("kxy")
    //隐式类
    println("123".add(2))
  }

}
