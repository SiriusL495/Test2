package com.sparkSQL.demo01

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object SQLTest_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("SQLTest_scala")
      .setMaster("local")
    val sqlContext = new SQLContext(new SparkContext(conf))
    val ds0 = sqlContext.read.json("./json")
    val ds = sqlContext.read.format("json").load("./json")
    ds.show()
    ds.printSchema()
    //select count(*) groupby age
    ds.groupBy(ds.col("age")).count().show()
    val ds2 = ds.select(ds.col("age"),ds.col("name")).where(ds.col("age").gt(18))
    ds2.show
    ds.createOrReplaceTempView("test1")
    val ds3 = sqlContext.sql("select * from test1 where age = 17")
    ds3.show()

  }
}
