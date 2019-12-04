package com.spark.demo10

import org.apache.spark.{SparkConf, SparkContext}

object Accumulator22_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Accumulator22_scala")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sum = sc.longAccumulator("count")
    val rdd1 = sc.parallelize(1 to 100).map(x=>{
      if(x%2==0){
        sum.add(1)
      }
    })
    println("count = "+rdd1.count())
    println("accumulator = "+sum.value)
    sc.stop()
  }
}
