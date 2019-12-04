package com.spark.demo08

import org.apache.spark.{SparkConf, SparkContext}

class SecondarySortKey_scala(val first: Int, val second: Int) extends Ordered[SecondarySortKey_scala] with Serializable {
  override def compare(that: SecondarySortKey_scala): Int = {
    if (this.first - that.first != 0) {
      this.first - that.first
    } else {
      this.second - that.second
    }
  }
}

object SecondarySortKey_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SecondarySortKey_scala").setMaster("local")
    val sc = new SparkContext(conf)
    sc.textFile("./testSecond")
      .map(line => (new SecondarySortKey_scala(line.split(" ")(0).toInt, line.split(" ")(1).toInt), line))
      .sortByKey()
      .map(_._2)
      .foreach(println)
  }
}
