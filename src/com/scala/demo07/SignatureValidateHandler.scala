package com.scala.demo07

trait SignatureValidateHandler extends Handler {

  override def handle(data: String): Unit = {
    println("check Signature " + data)
    super.handle("SVH")
  }

}
