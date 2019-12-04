package com.scala.demo10

object Test3 {

  val grades = Map("zhangsan"->"A","Jack"->"B","Jen"->"C")

  def main(args: Array[String]): Unit = {
    getGrade("zhangsan")

  }

  def getGrade(name:String): Unit ={
    val grade = grades.get(name)
    grade match {
      case Some(grade) => println("your grade is "+grade)
      case None => println("your info is not in the system")
      case _ =>println("whatever")
    }
  }

}
