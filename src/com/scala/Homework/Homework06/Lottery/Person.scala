package com.scala.Homework.Homework06.Lottery

import scala.io.StdIn

class Person {
  var name = ""
  var money = 0

  def buyLottery: Array[Int] ={
    println("购买彩票号码：")
    val n1 = StdIn.readInt()
    val n2 = StdIn.readInt()
    val n3 = StdIn.readInt()
    val lotNum = Array(n1,n2,n3)
    money-=10
    lotNum
  }

  def check: Unit ={
    val sys = new System
    if(buyLottery sameElements sys.bingoNo){
      println("中奖")
      money+=200
    }else{
      println("未中奖")
    }

  }

  def notice: Unit ={
    println("剩余金钱："+money)
  }

}
