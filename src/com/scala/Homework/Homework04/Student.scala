package com.scala.Homework.Homework04

class Student {
  private var grade:Int = 0
  private var profession:String =" "
  private var schoolName:String = " "


  def setgrade_=(newGrade:Int): Unit ={
    grade = newGrade
  }

  def getgrade = grade

  def setProfession_=(newPro:String): Unit ={
    profession = newPro
  }

  def getProfession= profession

  def setSchoolName_=(newSN:String): Unit ={
    schoolName = newSN
  }

  def getSchoolName = schoolName

}
