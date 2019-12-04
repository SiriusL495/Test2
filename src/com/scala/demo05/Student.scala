package com.scala.demo05

object Test {
  def main(args: Array[String]): Unit = {
    val p: Person = new Student
    //Person p = new Student() -- Java
    p match {
      case per: Person => println("Person object")
      case per: Student => println("Student object")
      case _ => println("Unknown type")
    }
  }
}

class Student extends Person {

}
