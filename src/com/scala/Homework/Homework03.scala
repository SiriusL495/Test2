package com.scala.Homework

import scala.collection.immutable._
import scala.collection.mutable
import scala.util.Sorting
import scala.util.Sorting._

object Homework03 {
  def main(args: Array[String]): Unit = {

    //    //作业1:移除数组第一个负数之后的所有的负数
    //    val a = Array(1, -2, 5, -7, -9, 15, -6)
    //    var flag = 0
    //    var index = 0
    //    var i = -1
    //    a.foreach(e => if (flag == 0) {
    //      if (e >= 0) index += 1; if (e < 0) flag = 1
    //    })
    //    a.filter { e => i += 1; e >= 0 || i == index }.foreach(println)

    //    //SortedMap
    //    val map = Map("zhangsna"->90,"lisi"->70,"wangwu"->80)
    //    println(map)
    //    val smap = SortedMap("zhangsna"->90,"lisi"->70,"wangwu"->80)
    //    println(smap)

    //    //LinkedHashMap
    //    val hm = mutable.HashMap("10086"->15202,"1"->1,"19982485"->95548,"2"->1)
    //    println(hm)
    //    val lhm = mutable.LinkedHashMap("10086"->15202,"1"->1,"19982485"->95548,"2"->1)
    //    println(lhm)

    //    //作业3:给定一个整数数组 nums 和一个目标值 target,请你在该数组中找出和为目标值的两个整数
    //    val nums = Array(2, 7, 11, 15)
    //    val target = 9
    //    var arr = twoSum(nums, target)
    //    printf("[%d,%d]", arr(0), arr(1))

    //    //作业4.	计算数组中最大数与最小数的差.
    //    val a = Array(1,5,9,4,7,3)
    //    quickSort(a)
    //    print(a(a.length-1)-a(0))

    //    //作业5.	写一个方法,求数组的连接
    //    var a = Array(1, 2, 3, 4, 5)
    //    var b = Array(6, 9, 6, 8, 7)
    //    var c = conArray(a, b)
    //    print(c.mkString("{",",","}"))

    //作业7：写一个程序，求一个5*5数阵中的马鞍数，输出它的位置。

    //    //作业8：用冒泡、快速两种排序法将数组{2,1,7,9,7,6,4,2,3,5}按升序排列
    //    val arr = Array(2,1,7,9,7,6,4,2,3,5)
    //    quickSort(arr)
    //    println(arr.mkString(","))
    //
    //    val arr2 = Array(2,1,7,9,7,6,4,2,3,5)
    //    for(i <- arr2.indices){
    //      for(j <- 0 to arr2.length -i -2){
    //        if(arr2(j)>arr2(j+1)){
    //          val temp = arr2(j+1)
    //          arr2(j+1) = arr2(j)
    //          arr2(j) = temp
    //        }
    //      }
    //    }
    //    println(arr2.mkString(","))


    //    //作业9
    //    var map = mutable.Map[String, String]()
    //    map += ("13" -> "zhangsan")
    //    map += ("11" -> "zhangsan")
    //    map += ("1" -> "zhangsan")
    //    map += ("5" -> "zhangsan")
    //    map += ("9" -> "zhangsan")
    //    map += ("6" -> "zhangsan")
    //    map += ("2" -> "zhangsan")
    //    map += ("3" -> "zhangsan")
    //    map += ("7" -> "zhangsan")
    //    map += ("14" -> "zhangsan")
    //    map += ("4" -> "zhangsan")
    //    map += ("8" -> "zhangsan")
    //    map += ("10" -> "zhangsan")
    //    map += ("15" -> "zhangsan")
    //    map += ("12" -> "zhangsan")
    //    val smap = map.toList.sortBy(-_._1.toInt)
    //    smap.foreach(println)


    //    //作业10：请把学生名与考试分数录入到Map中,并按分数显示前三名成绩学员的名字。
    //    var map = mutable.Map[String,Int]()
    //    map += ("zhangsan" -> 60)
    //    map += ("lisi" -> 90)
    //    map += ("wangwu" -> 79)
    //    map += ("wangba" -> 97)
    //    map += ("gaozi" -> 87)
    //    map += ("duzi" -> 91)
    //    val smap = map.toList.sortBy(-_._2)
    //    for(i <- 1 to 3){
    //      println(smap(i))
    //    }
  }

  def conArray(a: Array[Int], b: Array[Int]): Array[Int] = {
    a ++ b
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- nums.indices) {
      for (j <- nums.indices) {
        if (nums(i) + nums(j) == target)
          return Array(nums(i), nums(j))
      }
    }
    Array()
  }

}
