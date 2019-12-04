package com.sparkSQL.demo08

import org.apache.spark.SparkContext
import org.apache.spark.sql.types.{DataTypes, StringType, StructField}
import org.apache.spark.sql.{RowFactory, SparkSession}

object UDFDemo_scala {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("UDFDemo_scala")
      .master("local")
      .getOrCreate()
    val sc = SparkContext.getOrCreate()

    val rowRDD = sc.makeRDD(Array("zhangsan","lisi","wangwu")).map(x=>RowFactory.create(x))
    val schema = DataTypes.createStructType(Array(StructField("name",StringType,true)))
    val df = spark.createDataFrame(rowRDD,schema)
    df.createOrReplaceTempView("user")
    spark.udf.register("StringLen",(s:String,i:Int)=>{s.length()+i})
    spark.sql("select name,StringLen(name,1) as length from user").show()
  }

}
