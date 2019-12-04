package com.scala.demo03

import scala.collection.mutable.ArrayBuffer

class Student7 {

  class Student(val name: String) {
    println(name)
  }

  val students = new ArrayBuffer[Student]

  def getStudent(name: String): Student = {
    new Student(name)
  }
}
