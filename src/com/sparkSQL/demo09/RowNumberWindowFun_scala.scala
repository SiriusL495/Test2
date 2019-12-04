package com.sparkSQL.demo09

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object RowNumberWindowFun_scala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("window")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc);
    hiveContext.sql("use spark")
    hiveContext.sql("drop table if exists sales")
    hiveContext.sql("create table if not exists sales ( date1 string,category string,price int )" + "row format delimited fields terminated by '\t'")
    hiveContext.sql("load data local inpath '/home/homework/sales' into table sales ")
    val result = hiveContext.sql("select date1,category,price from" + " (select date1,category,price," + "row_number()over(partition by date1 order by price desc) rank from sales) t" + "where t.rank<=3")
    result.show()
    sc.stop()
  }
}
