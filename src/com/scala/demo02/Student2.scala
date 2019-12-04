package com.scala.demo02

class Student2 {

  private var myname = "jack"

  def name = "your name is " + myname
  def name_= (newValue:String): Unit = {
    println("name is uneditable")
    myname = newValue
  }
}
