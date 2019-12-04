package com.scala.Homework.Homework04

class Person {
  private var age: Int = 0
  private var name: String = ""

  var stu = new Student

  def setGrade(grade:Int) = stu.setgrade_=(grade)
  def getGrade = stu.getgrade

  def setProfession(pro:String) = stu.setProfession_=(pro)
  def getProfession = stu.getProfession

  def setSchoolName(sn:String) = stu.setSchoolName_=(sn)
  def getSchoolName = stu.getSchoolName

  def getage = age

  def setage_=(newAge: Int): Unit = {
    age = newAge
  }

  def getname = name

  def setname_=(newName: String): Unit = {
    name = newName
  }

  def printPerson(): Unit ={
    val g = getGrade
    val p = getProfession
    val s = getSchoolName

    printf("age=%d, name=%s, grade=%d, profession=%s, schoolName=%s",age,name,g,p,s)
  }

}
