package com.scala.demo13

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

@SerialVersionUID(44L) class Person(val name:String)extends Serializable
object TestSerializable {

  def main(args: Array[String]): Unit = {
    val zhangsan = new Person("zhangsan")
    val oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\SiriusL\\Desktop\\aaa.txt"))
    oos.writeObject(zhangsan)
    oos.close()

    val ois = new ObjectInputStream(new FileInputStream("C:\\Users\\SiriusL\\Desktop\\aaa.txt"))
    val restored = ois.readObject().asInstanceOf[Person]
    println(restored.name)

  }

}
