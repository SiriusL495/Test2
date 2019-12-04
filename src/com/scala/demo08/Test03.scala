package com.scala.demo08

object Test03 {
  def main(args: Array[String]): Unit = {
    //Array(2,4,6,8).map((num:Int) => println(2+num))
    Array(2, 4, 6, 8).map(2 + _).foreach(println)
    //filter对传入的每个元素进行条件判断，如果返回true则保留。
    (1 to 20).filter(_ % 2 == 0)
    //从左侧元素开始进行reduce操作，即先对元素1和2进行处理，然后将结果与3进行处理
    (1 to 9).reduceLeft(_ * _)
    println((1 to 9).sum)

    Array(9,7,6,4,3,1,5).sortWith(_>_).foreach(print)
    println()
    (1 to 9).map("*"*_).foreach(println)

    val test03 = new Test03
    test03.getGreetingFunc("WDNMD")("250")
    test03.getGreetingHello("250")
    test03.getGreetingHi("250")

  }
}

class Test03{
  def getGreetingFunc(message:String) = (name:String) => println(message+","+name)
  val getGreetingHello = getGreetingFunc("Hello")
  val getGreetingHi = getGreetingFunc("Hi")
}