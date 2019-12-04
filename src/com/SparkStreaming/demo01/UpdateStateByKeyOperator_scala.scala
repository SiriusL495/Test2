package com.SparkStreaming.demo01

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}

object UpdateStateByKeyOperator_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("UpdateStateByKeyOperator")
      .setMaster("local[2]")
    val jsc = new StreamingContext(conf, Durations.seconds(5))
    jsc.checkpoint("hdfs://virhost00:9000/user/spark/checkpoint")
    val lineDStream = jsc.socketTextStream("virhost00", 9999)
    val wordDStream = lineDStream.flatMap(_.split(" "))
    val pairDStream = wordDStream.map(_ -> 1)
    val result = pairDStream.updateStateByKey((seq: Seq[Int], option: Option[Int]) => {
      var value = 0
      value += option.getOrElse(0)
      for(elem <-seq){
        value += elem
      }
      Option(value)
    })

    result.print()
    jsc.start()
    jsc.awaitTermination()
    jsc.stop()

  }
}
