package com.scala.Homework.Homework04

class Point {
  private var pname = ""
  private var distance = 0

  def dis = distance
  def dis_=(newDis:Int): Unit ={
    distance = newDis
  }

  def name = pname
  def name_=(newName:String): Unit ={
    pname = newName
  }

  def this(name:String,distance:Int){
    this()
    this.pname = name
    this.distance = distance
  }

}
