package com.scala.demo03

class Student6 {
  private var name = ""
  private var age = 0
  println("name = " + name + ",age = " + age)
  def this(name: String) {
    this()
    this.name = name
    println("name = " + name + ",age = " + age)
  }

  def this(name: String, age: Int) {
    this(name)
   // this.age = age
    println("name = " + name + ",age = " + age)
  }
}
