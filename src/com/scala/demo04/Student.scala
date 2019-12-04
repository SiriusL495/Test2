package com.scala.demo04

class Student extends Person4 {
  private var score = "A"

  def getScore = score

  override def getName: String = "Go fuck yourself, " + super.getName
}
