package com.scala.demo07

trait DataValidateHandler extends Handler {

  override def handle(data: String): Unit = {
    println("check Data " + data)
    super.handle("DVH")
  }

}
