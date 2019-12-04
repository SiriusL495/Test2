package com.scala.Homework

import java.text.SimpleDateFormat
import java.util.Date

import scala.io.StdIn

object Homework02 {
  def main(args: Array[String]): Unit = {
    //1.	写一个函数来判断一个人的出生日期是否为闰年
    //    print("请输入出生日期(yyyy-MM-dd)：")
    //    val str:String = StdIn.readLine()
    //    T1(str)

    //2.	写一个函数：给出0~100分成绩，显示为“优秀”(90以上)，“良好”（80～89），“及格”（60～79），“不及各”（60以下）。
    //    print("请输入成绩：")
    //    val n: Int = StdIn.readInt()
    //    T2(n)

    //3.	写一个函数，打印当前时间，并调用。
    //    T3()

    //4.	设计一个函数boolean prime(int n)，用来判断数n是否为素数，若为素数，返回true; 若不是素数，返回false;若n<0,抛出ArgumentOutOfBound异常。
    //    print("请输入数字：")
    //    val n: Int = StdIn.readInt()
    //    prime(n)

    //5.	针对下列Java循环编写一个Scala版本:for(int i=10;i>=0;i–)System.out.println(i);
    //T5()

    //6.	编写函数计算xn,其中n是整数，使用如下的递归定义:
    print("x = :")
    var x = StdIn.readInt()
    print("n = :")
    var n = StdIn.readInt()
    println(T6(x,n))

  }

  def T1(date: String): Unit = {
    var year = date.substring(0, 4).toInt
    if ((year % 4) == 0 && (year % 400) == 0 && (year % 3200) != 0) {
      printf("%d年是闰年", year)
    } else {
      printf("%d年不是闰年", year)
    }
  }

  def T2(i: Int): Unit = {
    if (i >= 90) {
      print("优秀")
    } else if (i < 90 && i >= 80) {
      print("良好")
    } else if (i < 80 && i >= 60) {
      print("及格")
    } else if (i < 60) {
      print("不及格")
    }
  }

  def T3(): Unit = {
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    print(date)
  }

  def prime(in: Int): Int = {
    var flag: Int = 0
    var isPrime: Array[Boolean] = new Array[Boolean](100)
    if (in >= 0) {
      for (i <- isPrime.indices) {
        isPrime(i) = true
      }
      for (i <- 2 until isPrime.length) {
        for (k <- 2 until isPrime.length) {
          if (i * k < isPrime.length) {
            isPrime(i * k) = false
          }
        }
      }
      if (isPrime(in)) {
        print("是素数")
      } else {
        print("不是素数")
      }
    } else {
      print("ArgumentOutOfBoundException")
    }
    flag
  }

  def T5(): Unit = {
    for (i <- (1 to 10).reverse) {
      println(i)
    }
  }

  def T6(x: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n > 0 && n % 2 == 0) T6(x, n / 2) * T6(x, n / 2)
    else if (n>0 && n%2==1)x* T6(x,n-1)
    else 1/T6(x,-n)
  }

}
