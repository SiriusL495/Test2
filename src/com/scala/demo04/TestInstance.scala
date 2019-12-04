package com.scala.demo04

object TestInstance {
  def main(args: Array[String]): Unit = {
    val a:Int = 5
    if(a.isInstanceOf[Int]){
      a.asInstanceOf[Long]
      println(a)
    }else{

    }
//    a match {
//      case i:String => println(a)
//      case j:Int => a.asInstanceOf[Int]
//    }
  }
}
