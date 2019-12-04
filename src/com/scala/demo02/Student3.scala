package com.scala.demo02

class Student3 {
  private var myAge = 0

  def age_=(newValue: Int): Unit = {
    if (newValue > 0) myAge = newValue
    else println("Illegal age")

  }
  def age = myAge

  //在类的方法中，可以直接访问类的其他对象的private的field
  def older(s:Student3) ={
    myAge > s.myAge
  }
}
