package com.scala.demo04

class Student6 extends Person6 {
  val p:Person6 = new Student6
  var s:Student6 = null
  if(p.isInstanceOf[Student6]) s = p.asInstanceOf[Student6]
  p match{
    case i:Student6 => s = p.asInstanceOf[Student6]
  }
}
