package com.scala.Homework

object Homework10 {
  def main(args: Array[String]): Unit = {
    //第一题
    var arr = Array(1,2,3,4,5,6,3,1,3,4)
    //take：取前n个元素
    println(arr.take(3).mkString(","))
    //drop:删除前n个元素
    println(arr.drop(5).mkString(","))
    //takeRight:取从右往左第n个元素
    println(arr.takeRight(4).mkString(","))
    //dropRight:删除从右往左第n个元素
    println(arr.dropRight(5).mkString(","))

    swap(Array(1,2,34,4))

    println(sum(List(Some(1),None,Some(2),Some(3),None)))

  }

  def swap(a: Array[Int]): Unit = {
    if (a.length > 2) {
      a match {
        case Array(a, b, c@_*) => println((Array(b, a) ++ c).mkString(","))
      }
    } else {
      println("数组长度应大于2")
    }

  }

  def sum(list:List[Option[Int]]): Int ={
    list.map(_.getOrElse(0)).sum
  }

}
