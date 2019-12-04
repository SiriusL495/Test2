package com.scala.demo13

object TestRegular {

  def main(args: Array[String]): Unit = {
    //定义一个正则表达式，使用String类的r方法
    //此时返回的类型是scala.util.matching.Regex类的对象
    val pattern1 = "[1-9]+".r
    val str = "hello 123 world 456"
    for(matchString <- pattern1.findAllIn(str))println(matchString)
    //获取第一个匹配正则表达式的部分
    for(matchString <- pattern1.findFirstIn(str))println(matchString)
  }

}
