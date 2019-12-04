package com.scala.demo04

object Person {

  private var eyesNum = 2
  println("this person object")
  def getEyesNum = eyesNum

  def main(args: Array[String]): Unit = {
    println(getEyesNum)
  }

}
