package com.scala.Homework.Homework04

import scala.math._

object TestPoint {
  def main(args: Array[String]): Unit = {
    var p1 = new Point("a",10)
    var p2 = new Point("b",19)
    distance(p1,p2)
  }

  def distance(a:Point,b:Point): Unit ={
    val dis_a = a.dis
    val dis_b = b.dis
    val name_a = a.name
    val name_b = b.name
    printf("%s到%s的距离为%d",name_a,name_b,abs(dis_a-dis_b))
  }

}
