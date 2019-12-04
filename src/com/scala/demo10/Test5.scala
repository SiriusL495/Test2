package com.scala.demo10

object Test5 {
  def main(args: Array[String]): Unit = {
    val leo = new Student[Int](111)
    println(leo.getSchoolId(456))
  }

  class Student[T](val localId:T){
    def getSchoolId(hukou:T)="S-"+localId+" "+hukou
  }
}
