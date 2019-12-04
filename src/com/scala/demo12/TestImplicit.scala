package com.scala.demo12
class Man(val name:String)
class SuperMan(val name:String){
  def emitLaser = println("bzzzzzzz")
}
object TestImplicit {
  implicit def man2superman(man:Man):SuperMan = new SuperMan(man.name)

  def main(args: Array[String]): Unit = {
    val man = new Man("250")
    man.emitLaser

  }

}
