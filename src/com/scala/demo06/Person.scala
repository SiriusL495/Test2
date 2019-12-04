package com.scala.demo06

class Person extends Hello with Friends with Serializable {
  var name = "zhangsan"
  override def sayHello(name:String): Unit = {
    println("Hello, "+name)
  }

  override def makeFriends(p: Person): Unit = {
    println("make friends with "+p)
  }

}
