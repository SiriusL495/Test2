package com.spark.demo06

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

object Transformation2_scala {
  def main(args: Array[String]): Unit = {
    //zip()
    //rightOuterJoin()
    //fullOuterJoin()
    //union()
    //intersection()
    //subtraction()
    mapPartition()
  }

  def zip(): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c"), (4, "d"), (5, "e"), (6, "f")))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6)))
    rdd1.zipWithIndex().foreach(println)
    rdd1.zip(rdd2).foreach(println)
    sc.stop()
  }

  /**
    * leftOuterJoin:左所有元素与右连接
    * rightOutJoin：右所有元素与左连接
    * fullOuterJoin全连接
    * Union：直接连接
    * intersection：只保留a和b都有的
    * subtract:在a中去掉a和b都有的
    */

  def leftOuterJoin(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c"), (4, "d"), (5, "e")))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6)))
    rdd1.leftOuterJoin(rdd2).foreach(x=>println(x._1+" "+x._2._1+" "+x._2._2))
  }

  def rightOuterJoin(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c"), (4, "d"), (5, "e")))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4)))
    rdd1.rightOuterJoin(rdd2).foreach(x=>println(x._1+" "+x._2._1+" "+x._2._2))
  }

  def fullOuterJoin(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c"), (4, "d"), (5, "e")))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (6, 6)))
    rdd1.fullOuterJoin(rdd2).foreach(x=>println(x._1+" "+x._2._1+" "+x._2._2))
  }

  def union(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (6, 6)))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (5, 5)))
    rdd1.union(rdd2).foreach(println)
  }

  def intersection(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (6, 6)))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (5, 5)))
    rdd1.intersection(rdd2).foreach(println)
  }

  def subtraction(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (6, 6)))
    val rdd2 = sc.parallelize(Array((1, 1), (2, 2), (3, 3), (4, 4), (5, 5)))
    rdd1.subtract(rdd2).foreach(println)
  }

  def mapPartition(): Unit ={
    val conf = new SparkConf().setAppName("reduce").setMaster("local")
    val sc = new SparkContext(conf)
    val arr = Array("class1", "class2", "class3", "class4", "class5", "class6", "class7", "class8", "class9", "class10", "class11", "class12", "class13")
    sc.parallelize(arr).mapPartitionsWithIndex((index,iterator)=>{
      val list = new ArrayBuffer[String]
      while (iterator.hasNext){
        val one = iterator.next()
        list += ("rdd1.partition index="+index+",value="+one)
      }
    list.iterator
    },true).coalesce(4,true).mapPartitionsWithIndex((index,iterator)=>{
      val list = new ArrayBuffer[String]
      while (iterator.hasNext){
        val one = iterator.next()
        list += ("rdd2.partition index="+index+",value="+one)
      }
      list.iterator
    },true).collect().foreach(println)
  }

}
