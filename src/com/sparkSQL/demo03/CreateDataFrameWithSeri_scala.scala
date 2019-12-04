package com.sparkSQL.demo03

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

case class Person1(id:String,name:String,age:Integer)

object CreateDataFrameWithSeri_scala {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("CreateDataFrameWithSeri")
      .master("local")
      .getOrCreate()
    val sc = SparkContext.getOrCreate()
    val personRDD = sc.textFile("./person.txt").map(x=>{
      val p = Person1(x.split(",")(0),x.split(",")(1),x.split(",")(2).toInt)
      p
    })
    import spark.implicits._
    val df = personRDD.toDF()
    df.show()
    personRDD.foreach(println)
    val rdd = df.rdd
    val result = rdd.map(x=>{
      Person1(x.getAs("id"),x.getAs("name"),x.getAs("age"))
    })
    result.foreach(println)
    sc.stop()
  }
}
