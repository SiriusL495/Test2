package com.scala.demo09

object Test02 {
  def main(args: Array[String]): Unit = {
    //因为List调用其Apply函数，所以Scala中多数的new都被Apply取代了
    val list = List(1, 2, 3, 4)
    //list.foreach(println)

    val resultList = scala.collection.mutable.LinkedList(1,2,3,4,5)

    //使用循环语句将每个元素*2

    resultList.map(x=>x*2).foreach(println)

    for(i <- resultList.indices){
      resultList(i) = resultList(i)*2
    }
    resultList.foreach(println)

  }
}

class Test02 {

}
