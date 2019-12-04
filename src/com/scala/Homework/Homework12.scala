package com.scala.Homework

import java.io.{File, PrintWriter}

import scala.io.Source

object Homework12 {
  def main(args: Array[String]): Unit = {
    //T1
    //println(T1(new File("D:\\bigdata")).length)
    //T2
    T3
  }

  def T1(dir: File): Iterator[File] = {
    val childDirs = dir.listFiles.filter(_.isDirectory)
    val isFile: Array[File] = dir.listFiles.filter(_.getName.endsWith("class"))

    isFile.toIterator ++ childDirs.toIterator.flatMap(x => T1(x))
  }

  def T2: Unit ={
    val source = Source.fromFile("C:\\Users\\SiriusL\\Desktop\\aaa.txt", "UTF-8")
    val pattern = "[a-zA-Z0-9]+".r
    for(line<-source)
      {
        for(matchStr <-pattern.findAllIn(line.toString)) print(matchStr)
      }
  }

  def T3: Unit ={
    val pw = new PrintWriter("C:\\Users\\SiriusL\\Desktop\\bbb.txt")
    for(n<-1 to 20){
      val t = BigDecimal(2).pow(n)
      pw.write(t.toString())
      pw.write("\t\t")
      pw.write((1/t).toString())
      pw.write("\n")
    }
    pw.close()
  }

}
