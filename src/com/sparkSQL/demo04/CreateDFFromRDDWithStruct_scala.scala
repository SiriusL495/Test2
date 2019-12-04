package com.sparkSQL.demo04

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{RowFactory, SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object CreateDFFromRDDWithStruct_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("CreateDFFromRDDWithStruct_scala")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val spark = SparkSession
      .builder()
      .appName("CreateDFFromRDDWithStruct_scala")
      .master("local")
      .getOrCreate()

    val lineRDD = sc.textFile("./person.txt").map(x=>{
      RowFactory.create(x.split(",")(0),x.split(",")(1),Integer.valueOf(x.split(",")(2)))
    })
    val schema = StructType(
      List(
        StructField("id",StringType,true),
        StructField("id",StringType,true),
        StructField("id",IntegerType,true)
      )
    )
    val df = sqlContext.createDataFrame(lineRDD,schema)
    df.show()
    df.printSchema()
    sc.stop()
  }
}
