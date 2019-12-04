package com.scala.demo10

class Master {

}
class Professional extends Master
//+T表示类型为某个类时，传入其子类或其本身 协变
class Card[+T](val name:String)
////+T表示类型为某个类时，传入其父类或其本身 逆变
//class Card[-T](val name:String)
object Master{
  def main(args: Array[String]): Unit = {
    enterMeeting(new Card[Professional]("zhangsan"))
  }
  def enterMeeting(card:Card[Master]): Unit ={
    println("welcom to this meeting, "+card.name)
  }
}