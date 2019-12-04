package com.scala.Homework.Homework04

class Stu {
  private var name = ""
  private var age = 0

  def this(name:String,age:Int){
    this()
    this.name = name
    this.age = age
  }

  def showInfo(): Unit ={
    printf("name = %s, age = %d",name,age)
    println()
  }

}
