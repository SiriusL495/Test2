package com.scala.Homework.Homework04

object TestStu {
  def main(args: Array[String]): Unit = {
    var stu = new Stu("zhangsan",18)
    var stu2 = new Stu("lisi",20)
    var stu3 = new Stu("wangwu",19)
    stu.showInfo()
    stu2.showInfo()
    stu3.showInfo()
  }
}
