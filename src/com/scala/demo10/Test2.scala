package com.scala.demo10

import java.io.{FileNotFoundException, IOException}

import scala.io.StdIn

object Test2 {
  def main(args: Array[String]): Unit = {
    //print("PLS ENTER YOUR GRADE:")
    //judgeGrade(StdIn.readLine().toUpperCase)

    /**
      * 给出一个成绩
      * 90-100，优秀
      * 80-90，良好
      * 60-80，及格
      * 其他，继续努力
      */
    //judge(StdIn.readInt())

    //judgeGrade2("zhangsan","G")

    //processException(new IOException())

   // greeting(List("leo","zhangsna","lisi","wangwu"))

    greetingArray(Array("leo","leo2","leo3"))

  }


  def judge(grade: Int): Unit = {
    grade match {
      case _ if 90 <= grade && grade <= 100 => println("优秀")
      case _ if 80 <= grade && grade < 90 => println("良好")
      case _ if 60 <= grade && grade < 80  => println("及格")
      case _ => println("...")
    }
  }

  def judgeGrade(grade: String): Unit = {
    grade match {
      case "A" => println("Excellent")
      case "B" => println("Good")
      case "C" => println("Fine")
      case "D" => println("Idiot")
      case _ => println("...")
    }
  }

  //对于_情况，打印匹配的值
  def judgeGrade2(name:String,grade: String): Unit = {
    grade match {
      case "A" => println("Excellent")
      case "B" => println("Good")
      case "C" => println("Fine")
      case "D" => println("Idiot")
      case _grade if name == "zhangsan" => println(name+"your grade is "+_grade)
      case _ => println(grade)
    }
  }

  def processException(ex:Exception): Unit ={
    ex match {
      case e1:IllegalArgumentException =>println("you have illegal argument exception is"+e1)
      case e2:FileNotFoundException => println("file not found. exception is:"+e2)
      case e3:IOException => println("you have an error while you were doing IO operation. exception is:"+e3)
      case _:Exception => println("exception unknown")
    }
  }


  //类型匹配
  def greeting(list:List[String]): Unit ={
    list match{
      case "leo" :: Nil =>println("Hi,Leo")
      case girl1::girl2::girl3 ::Nil =>println("Hi, girls "+girl1+" and "+girl2+" and "+girl3)
      case "leo"::tail =>println("Hi,Leo,pls introduce yourself")
      case _ =>println("Hey,who are you")
    }
  }

  def greetingArray(array: Array[String]): Unit ={
    array match {
      case Array("leo") => println("case 1")
      case Array(a,b,c,d) => println("case 2 "+a+b+c+d)
      case Array("leo",_*)=>println("case 3")
      case _ => println("...")
    }
  }

}
