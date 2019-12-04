package com.scala.Homework.Homework06.Lottery

import scala.io.StdIn

object TestResult {
  def main(args: Array[String]): Unit = {
    var person = new Person
    person.name = "zhangsan"
    person.money = 200

    var flag = true
    var con = "Y"

    while(flag){
      person.check
      person.notice
      println("是否继续购买？(Y/N)")
      con = StdIn.readLine().toUpperCase

      if(con == "N"){
        flag = false
        println("欢迎下次再来")
      }

    }
  }
}
