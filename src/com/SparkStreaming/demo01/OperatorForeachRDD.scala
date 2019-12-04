package com.SparkStreaming.demo01

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Durations, StreamingContext}

object OperatorForeachRDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("OperatorForeachRDD")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val jsc = new StreamingContext(sc,Durations.seconds(5))
    val socketDStream = jsc.socketTextStream("virhost00",9999)

    /**
      * outputOperation算子，必须对抽取出来的RDD执行action类算子
      */
    socketDStream.foreachRDD(rdd=>{
      rdd.foreach(println)
    })
    jsc.start()
    jsc.awaitTermination()
    jsc.stop()
  }
}
