package com.scala.demo07

class Person extends SignatureValidateHandler with DataValidateHandler {

  def sayHello(name:String): Unit ={
    println("Hello,"+name)
    handle("张三")
  }


}
