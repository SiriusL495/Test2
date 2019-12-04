package com.scala.Homework.Homework05

class Student(override val age:Int,override val name:String,val grade:Int,val pro:String,val sn:String) extends Person {

  override def printMessage: Unit = {
    printf("age = %d, name = %s, grade = %d, profession = %s, schoolName = %s", super.getAge, super.getName, grade, pro, sn)
  }
}
