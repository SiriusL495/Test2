package com.scala.Homework.Homework06.Lottery

class Lottery {
  //var number = new Array[Int](3)
  var number: String = _
  var price: Float = _

  def Number:String = number
  def Number_=(newNumber:String): Unit ={
    number = newNumber
  }

  def Price:Float = price
  def Price_=(newPrice:Float): Unit ={
    price = newPrice
  }

  def showAllLottery(): Unit = {
    println("彩票号码：" + number + "价格：" + price)
  }
}
