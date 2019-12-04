package com.sparkSQL.demo03;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class CreateDataFrameWithSeri {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("CreateDataFrameWithSeri")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<String> lineRDD = sc.textFile("./person.txt");
        JavaRDD<Person> personRDD = lineRDD.map((String line)->{
           Person p = new Person();
           p.setId(line.split(",")[0]);
           p.setName(line.split(",")[1]);
           p.setAge(line.split(",")[2]);
           return p;
        });
        /**
         * 传入进person.class的时候，sqlContext是通过反射的方式创建DataFrame
         * 在底层通过反射的方式获得Person的所有field，结合RDD本身，生成DataFrame
         */
        Dataset df = sqlContext.createDataFrame(personRDD,Person.class);
        df.show();
        df.printSchema();
        df.registerTempTable("person");
        Dataset sql = sqlContext.sql("select name,id,age from person where id = 2");
        sql.show();
        /**
         * 将DataFrame生成JavaRDD
         */
        JavaRDD<Row> javaRdd = df.javaRDD();
        JavaRDD<Person> personJavaRDD = javaRdd.map((Row row)->{
            Person p = new Person();
            p.setId(row.getAs("id"));
            p.setName(row.getAs("name"));
            p.setAge(row.getAs("age"));
            return p;
        });
        personJavaRDD.foreach((Person p)->{
            System.out.println("ID: "+p.getId()+" Name:"+p.getName()+" Age:"+p.getAge());
        });
        sc.stop();

    }
}
