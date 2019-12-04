package com.scala.demo07

trait Handler {
 def handle(data:String): Unit ={
   println("---trait Handler---"+data)
 }
}
