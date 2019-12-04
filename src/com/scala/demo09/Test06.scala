package com.scala.demo09

object Test06 {
  val resultList = scala.collection.mutable.LinkedList(1,2,3,4,5)

  var currentList = resultList
  while(currentList!=Nil){
    currentList.elem = currentList.elem*2
    currentList = currentList.next
  }
  resultList.foreach(println)
}

