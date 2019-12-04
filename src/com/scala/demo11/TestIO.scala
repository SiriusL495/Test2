package com.scala.demo11

import scala.io.Source
import java.io._

object TestIO {
  def main(args: Array[String]): Unit = {
    //遍历一个文件中的每一行
    val source = Source.fromFile("C:\\Users\\SiriusL\\Desktop\\WordCount.txt", "UTF-8")
    val linesIterator = source.getLines
    for (line <- linesIterator) println(line)
    //getLines方法只能调用一次。调用一次之后，遍历了迭代器里的内容，就已经把文件的内容读取完了

    //将Source.getLines返回的迭代器转换成数组
    println("------------------------------source2-------------------------------")
    val source2 = Source.fromFile("C:\\Users\\SiriusL\\Desktop\\WordCount.txt", "UTF-8")
    source2.getLines().toArray.foreach(println)
    //println(linesIterator.toArray.mkString(","))

    //返回文本中的所有内容
    println("------------------------------source3-------------------------------")
    val source3 = Source.fromFile("C:\\Users\\SiriusL\\Desktop\\WordCount.txt", "UTF-8")
    println(source3.mkString)

    //遍历一个文件中的每一个字符
    println("------------------------------source4-------------------------------")
    val source4 = Source.fromFile("C:\\Users\\SiriusL\\Desktop\\WordCount.txt", "UTF-8")
    for (line <- source4) print(line)
    println()

    //从字符串中读取
    println("------------------------------string-------------------------------")
    val str = Source.fromString("Hello World")
    for (line <- str) print(line)
    println()

    //结合Java的输入输出流，读取任意的文件
    println("------------------------------Java.IO-------------------------------")
    val file = new File("C:\\Users\\SiriusL\\Desktop\\WordCount.txt")
    val bytes = new Array[Byte](file.length().toInt)
    val fis = new FileInputStream(file)
    fis.read(bytes)
    bytes.foreach(x => print(x.toChar))
    fis.close()

    //结合Java的IO流，写一个文件的拷贝
    val fis1 = new FileInputStream(new File("C:\\Users\\SiriusL\\Desktop\\WordCount.txt"))
    val fos1 = new FileOutputStream(new File("C:\\Users\\SiriusL\\Desktop\\WordCount2.txt"))

    val buf = new Array[Byte](1024)
    fis1.read(buf)
    fos1.write(buf, 0, 43)
    fis1.close()
    fos1.close()

    //结合Java的IO流，用printWriter写文件,覆盖原文件
    val pw = new PrintWriter("C:\\Users\\SiriusL\\Desktop\\WordCount2.txt")
    pw.println("Hello")
    println()
    pw.close()

    //递归遍历子目录
    println("------------------------------Java.IO.Iterator-------------------------------")
    val iterator = getSubDirIterator(new File("C:\\Users\\SiriusL\\Desktop\\Test123"))
    iterator.foreach(println)

  }

  /**
    * 递归遍历子目录及文件
    * ++的作用是连接集合等
    */

  def getSubDirIterator(dir: File): Iterator[File] = {

    val childDirs = dir.listFiles.filter(_.isDirectory)
    val isFile: Array[File] = dir.listFiles.filter(_.isFile)

    isFile.toIterator ++ childDirs.toIterator ++ childDirs.toIterator.flatMap(x => getSubDirIterator(x)).toList.sorted.toIterator
  }

}
