package com.scala.demo08

object Test{
  def main(args: Array[String]): Unit = {
    val test = new Test
   // test.sayHello("123")
   // test.greeting(test.sayHello,"Jack")

    /**
      * map有返回集合的值，foreach没有
      * 二者都可以遍历集合
      * (num:Int)=>println(num*num)
      */

    //Array(1,2,3,4,5).foreach((num:Int)=>println(num*num))
   // Array(1,2,3,4,5).foreach((num:Int)=>num*num)
    test.greetingFunc("jack")
    test.getGreetingFunc("123")("456")
  }
}

class Test {
  val sayHello = (name:String) =>println("Hello,"+name)
  def greeting(func:(String)=>Unit,name:String): Unit ={
    func(name)
  }

  def getGreetingFunc(msg:String) = (name:String) =>println(msg+","+name)
  //高阶函数将函数作为返回值
  val greetingFunc = getGreetingFunc("Hello")

}