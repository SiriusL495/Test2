package com.scala.demo08

object Test02 {
  def main(args: Array[String]): Unit = {
    val test = new Test02
    test.greeting((name:String)=>println("Hello,"+name),"Leo")
    //不指明参数类型，让其自行推断参数类型
    test.greeting((name)=>println("Hello,"+name),"Leo")
    test.greeting(name=>println("Hello,"+name),"Leo")
    println(test.triple(3*_))
    println(test.triple2((name:String)=>"hello,"+name))
    println(test.triple2(""+_))
  }
}
class Test02{
  def greeting(func:(String)=>Unit,name:String): Unit ={func(name)}
  def triple(func:(Int)=>Int)={func(3)}
  def triple2(func2:(String)=>String)={ func2("Test")}
}