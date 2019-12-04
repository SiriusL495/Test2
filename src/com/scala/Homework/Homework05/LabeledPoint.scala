package com.scala.Homework.Homework05

class LabeledPoint(val label:String, override val x:Int, override val y: Int) extends Point {
  def printMessage(): Unit ={
    printf("Label: %s, X: %d, Y: %d",label,super.getX,super.getY)
  }
}
