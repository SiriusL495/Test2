package com.scala.Homework.Homework04

class Teacher {
  private var id = 0
  private var name = ""
  private var sex = ""
  private var age = 0

  def getId = id
  def setId(newId:Int): Unit ={
    id = newId
  }

  def getName = name
  def setName(newName:String): Unit ={
    name = newName
  }

  def getSex = sex
  def setSex(newSex:String): Unit ={
    sex = newSex
  }

  def getAge = age
  def setAge(newAge:Int): Unit ={
    age = newAge
  }

  def isAge(): Unit ={
    if(age<35){
      println("年轻")
    }else if(age>35){
      println("人到中年")
    }
  }

  def printTeacher(): Unit ={
    printf("ID=%d, name=%s, sex=%s, age= %d",id,name,sex,age)
  }

}
