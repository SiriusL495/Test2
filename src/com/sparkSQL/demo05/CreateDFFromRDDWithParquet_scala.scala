package com.sparkSQL.demo05

import org.apache.spark.{SparkContext, sql}
import org.apache.spark.sql.{SaveMode, SparkSession}

object CreateDFFromRDDWithParquet_scala {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("CreateDFFromRDDWithParquet")
      .master("local")
      .getOrCreate()

    spark.read.json("./json").write.mode(SaveMode.Overwrite).parquet("./parquet_scala")
    spark.read.json("./json").write.mode(SaveMode.Overwrite).format("parquet").save("./parquet2_scala")

    spark.read.format("parquet").load("./parquet_scala").show()
    spark.read.parquet("./parquet2_scala").show()

  }
}
