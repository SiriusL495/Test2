package com.scala.Homework

object Test {
  def main(args: Array[String]): Unit = {
   T3
  }
  def T1: Unit = {
    for(i <- 1 to 9){
      for(j<-1 to i){
        print(i+"*"+j+"="+i*j+"\t")
      }
      println()
    }
  }

  def T2: Unit ={
    println(Set(1,2,3) & Set (2,4))//交集
    println(Set(1,2,3) &~ Set (2,4))//差集
    println(Set(1,2,3) ++ Set (2,4))//并集
  }

  def T3: Unit ={
    print(Set(2,4,5) +1 +1)
  }

}
