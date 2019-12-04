package com.scala.demo01

object TestTuple {
  def main(args: Array[String]): Unit = {
    val students = Array("Jack","Clark","Lili","Lisa")
    val scores = Array(80,90,100)
    var studentScores = students.zip(scores)
    for((student,score) <- studentScores){
      println(student+" "+score)
    }

    //如果Array的元素类型是Tuple，调用Array的toMap方法，可以将Array转换为Map
    println(studentScores.toMap)
  }
}
