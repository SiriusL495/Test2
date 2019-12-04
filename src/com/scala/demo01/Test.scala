package com.scala.demo01

import scala.util.control.Breaks._
import scala.math._

object Test {
  def main(args: Array[String]): Unit = {
    //    val i = 1.to(10)
    //    for(a <- i reverse){
    //      println(a)
    //    }

    //    println(sqrt(144))
    //    println(min(4,Pi))
    //    println("Hello World"(8))
    //    println("Hello World".apply(8))

    //    var age = 18
    //    println(if(age>16)1 else 0)

    //    var n = 5
    //    while (n > 0) {
    //      n -= 1
    //      println(n)
    //    }

    //    val a = 30
    //    var n = if (a > 18){20;6}
    //    print(n)

    //    breakable{
    //      var n =10
    //      for(c <- "Hello World"){
    //        if(n==6) break;
    //        print(c)
    //        n-=1
    //      }
    //    }

    //    var n = 10
    //    for (c <- "Hello World") {
    //      if (n == 6) {
    //        return
    //      }
    //      print(c)
    //      n -= 1
    //    }

    //add_outer()

    //    for(i <- 1 to 100 if i % 2 == 0){
    //      println(i)
    //    }
    //for推导：构建集合

    //print(for (i <- 1 to 10) yield i * 5)

    //    //乘法表
    //    for(x <- 1 to 9){
    //      for(y <- 1 to x){
    //        printf("%d * %d = %d\t",x,y,x*y)
    //      }
    //      println()
    //    }

    //    for (i <- 1 to 100 if (i == 98 || i > 81) if (i % 2 == 0)) {
    //      println(i)
    //    }

    //  var res = for (i <- 1 to 100 if (i % 10 == 0)) yield i
    //  print(res)
    //  println()
    //  print(res.mkString + "\n")
    //  res.foreach(a=>{println(a)})
    //  res.foreach(println)

    //    var name = "zhangsan"
    //    sayHello(name,3)

    //    sum(10)
    //    println(sum(10))

    //    println(fibo(8))

    //    sayHello2()

    //println(sum2(3,5,8))
    println(sum2(1 to 100: _*))

  }

  //  def add_outer(): Unit = {
  //    var res = 0
  //
  //    def add_inner(): Unit = {
  //      for (i <- 0 until 10) {
  //        if (i == 5) {
  //          return
  //        }
  //        println("i=" + i)
  //        res += 1
  //      }
  //    }
  //
  //    add_inner()
  //  }

  //  def sayHello(name:String,age:Int):Unit={
  //    printf("%s is %d years old",name,age)
  //  }

  //  def sum(n: Int): Int = {
  //    var res = 0
  //    for (i <- 1 to n) {
  //      res += i
  //      println("-----" + res)
  //    }
  //    res
  //  }

  //  //斐波那契数列
  //  def fibo(n:Int):Int={
  //    if (n==1||n==2) 1 else fibo(n-1)+fibo(n-2)
  //  }

  //    //默认值
  //  def sayHello2(name:String="zhangsan",age:Int=20):Unit={
  //    print(name+","+age)
  //  }

  def sum2(nums: Int*): Int = {
    var res = 0
    for (n <- nums) res += n
    res
  }

}
