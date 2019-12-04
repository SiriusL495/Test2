package com.scala.Homework.Homework04

object TestTeacher {
  var tea = new Teacher

  def main(args: Array[String]): Unit = {
    tea.setId(4399)
    tea.setName("zhangsan")
    tea.setSex("male")
    tea.setAge(50)

    tea.isAge()
    tea.printTeacher()
  }
}
