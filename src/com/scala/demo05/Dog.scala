package com.scala.demo05

object TestAnimal {
  def main(args: Array[String]): Unit = {
    val dog:Animal = new Animal
    dog match {
      case d:Dog => println("Dog Type")
      case a:Animal => println("Animal Type")
      case _ => println("Whatever")
    }
  }
}

class Dog extends Animal {

}
