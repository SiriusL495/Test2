package com.scala.Homework.Homework04

object TestPerson {
  def main(args: Array[String]): Unit = {
    var psn = new Person
    psn.setage_=(50)
    psn.setname_=("zhangsan")
    psn.setGrade(7)
    psn.setProfession("yuwen")
    psn.setSchoolName("aaa")

    psn.printPerson()

  }
}
