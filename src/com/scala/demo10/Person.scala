package com.scala.demo10

class Person {

}

case class Teacher(name: String, subject: String) extends Person

case class Student(name: String, classroom: String) extends Person

object Person {
  def main(args: Array[String]): Unit = {
    judgeId(Teacher("zhangsan", "english"))
  }

  def judgeId(p: Person): Unit = {
    p match {
      case Teacher(name, subject) => println("Teacher's name is " + name+ " subject is " + subject)
      case Student(name, classroom) => println("Student's name is " + name + " classroom is " + classroom)
      case _ => println("Error404")
    }
  }
}