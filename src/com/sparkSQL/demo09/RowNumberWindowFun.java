package com.sparkSQL.demo09;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.hive.HiveContext;

public class RowNumberWindowFun {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("windowFun")
                .set("spark.sql.shuffle.partitions","1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        HiveContext hiveContext = new HiveContext(sc);
        hiveContext.sql("use spark");
        hiveContext.sql("drop table if exists sales");
        hiveContext.sql("create table if not exists sales ( date1 string,category string,price int )" +
                "row format delimited fields terminated by '\t'");
        hiveContext.sql("load data local inpath '/home/homework/sales' into table sales ");

        /**
         * 开窗函数的格式：
         * row_number()over(partition by xxx order by xxx desc) as rank
         * rank从1开始
         * 以类别进行分组，按每种类别金额降序排序，显示[日期，种类，金额]的结果
         * 1    A   300
         * 2    B   500
         * 3    A   100
         * 4    B   400
         * 5    A   200
         * 6    B   600
         * 排序后
         * 1    A   300 --rank 1
         * 5    A   200 --rank 2
         * 3    A   100 --rank 3
         * 6    B   600 --rank 1
         * 2    B   500 --rank 2
         * 4    B   400 --rank 3
         */
        Dataset result =hiveContext.sql("select date1,category,price from" +
                " (select date1,category,price," +
                "row_number()over(partition by category order by price desc) rank from sales) t" +
                " where t.rank=3");
        result.show(100);
        /**
         * 将结果保存到Hive表中
         */
        result.write().mode(SaveMode.Overwrite).saveAsTable("sales_result");
        sc.stop();
    }
}
