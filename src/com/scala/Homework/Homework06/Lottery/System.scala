package com.scala.Homework.Homework06.Lottery

class System {
  def bingoNo(): Array[Int] ={
    val  str1 = scala.util.Random.nextInt(10)
    val  str2 = scala.util.Random.nextInt(10)
    val  str3 = scala.util.Random.nextInt(10)
    val bingo = "中奖号码："+str1+" "+str2+" "+str3
    println(bingo)
    var bingoNum = Array(str1,str2,str3)
    bingoNum
  }
}
