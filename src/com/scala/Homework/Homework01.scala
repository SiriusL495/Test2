package com.scala.Homework

import scala.io.StdIn

object Homework01 {
  def main(args: Array[String]): Unit = {
    //    //作业1：完成自己的学号、班级、姓名、指导老师的信息打印
    //    println("姓名：张三");
    //    println("学号： 160000");
    //    println("班级： 计算机");
    //    println("指导老师： 杨峰");

    //    //作业2：给定任意0～9999的数字，分别打印出其各个位的数字。
    //    print("输入4位数字：")
    //        val num:String = StdIn.readLine()
    //        val length:Int = num.length()
    //        length match{
    //          case 0 => println(0,0,0,0)
    //          case 1 => println(0,0,0,num(0))
    //          case 2 => println(0,0,num(0),num(1))
    //          case 3 => println(0,num(0),num(1),num(2))
    //          case 4 => println(num(0),num(1),num(2),num(3))
    //        }

    //    //作业3:十进制数转换为二进制数的方法
    //    val n:Int = 50
    //    print(n.toBinaryString)

    //    //作业4：在Linux下的权限，分为读，写，执行。分别对应4(100)，2(010)，1(001)。那么任意给一个0～7的数字，计算出该数字具有的权限。
    //        var str:String = ""
    //        var r:String = ""
    //        var w:String = ""
    //        var x:String = ""
    //        print("请输入权限(0-7的整数):")
    //        var n:Int = StdIn.readInt()
    //        val num = n
    //        while(n!=0){
    //          str = n % 2 + str
    //          n = n/2
    //        }
    //        if(str.length==1){
    //          str="00"+str
    //        }
    //        if(str.length==2){
    //          str="0"+str
    //        }
    //        if(str(0).toString.equals("1")){
    //          r = " 读 "
    //        }
    //        if(str(1).toString.equals("1")){
    //          w = " 写 "
    //        }
    //        if(str(2).toString.equals("1")){
    //          x = " 执行 "
    //        }
    //        println("您的权限为："+num+"("+str+")")
    //        println("您具有"+r+w+x+"的权限")

    //    //作业5：用Scala写一段代码，判断输入的一个年份是否是闰年
    //        print("请输入年份：")
    //        var n: Int = StdIn.readInt()
    //        if ((n % 4) == 0 && (n % 400) == 0 && (n % 3200) != 0) {
    //          printf(n + "年是闰年")
    //        } else {
    //          printf(n + "年不是闰年")
    //        }

    //    //作业6：定义三个整数，要求按照从小到大的顺序输出
    //    println("请输入三个整数：")
    //    var a:Int = StdIn.readInt()
    //    var b:Int = StdIn.readInt()
    //    var c:Int = StdIn.readInt()
    //        var t:Int = 0
    //        if(a>=b){
    //          t=a
    //          a=b
    //          b=t
    //        }
    //        if(a>=c){
    //          t=a
    //          a=c
    //          c=t
    //        }
    //        if(b>=c){
    //          t=b
    //          b=c
    //          c=t
    //        }
    //        print(a,b,c)

    //    //作业7：给定一个x的值，求y的值，并将y的结果输出
    //    print("请输入x：")
    //    var x: Int = StdIn.readInt()
    //        var y: Int = 10
    //        if (x > 0) {
    //          y = 1
    //        }
    //        if (x == 0) {
    //          y = 0
    //        }
    //        if (x < 0) {
    //          y = -1
    //        }
    //        print(y)

    //    //作业8：：1～100偶数的和。
    //    //for循环
    //        var n: Int = 1
    //        var sum: Int = 0
    //        for (n <- 1 to 100) {
    //          if (n % 2 == 0) {
    //            sum = sum + n
    //          }
    //        }
    //        print(sum)

    //    //while循环
    //        var n: Int = 1
    //        var sum: Int = 0
    //        while (n <= 100) {
    //          if (n % 2 == 0) {
    //            sum = sum + n
    //          }
    //          n += 1
    //        }
    //        print(sum)

    //    //作业9：1～100的和。
    //    //for循环
    //        var n:Int = 0
    //        var sum:Int = 0
    //        for(n <- 0 to 100){
    //          sum += n
    //        }
    //        print(sum)

    //    //while循环
    //        var n: Int = 0
    //        var sum: Int = 0
    //        while (n <= 100) {
    //          sum += n
    //          n += 1
    //        }
    //        print(sum)

    //    //作业10:打印图形：(n行)
    //    //for
    //    print("行数：")
    //    var a: Int = StdIn.readInt()
    //        var b: Int = 1
    //        var n: Int = 1
    //        for (n <- 1 to a) {
    //          for (n <- 1 to b) {
    //            print("*")
    //          }
    //          b += 1
    //          println()
    //        }

    //    //while
    //    print("行数：")
    //        var a: Int = StdIn.readInt()
    //        var b: Int = 1
    //        var n: Int = 1
    //        var m: Int = 1
    //        while(n<=a){
    //          while(m<=b){
    //            print("*")
    //            m+=1
    //          }
    //          n+=1
    //          b+=1
    //          m=1
    //          println()
    //        }

    //    //作业11:打印等腰三角形：(n行)
    //    //for
    //    print("行数：")
    //    val row: Int = StdIn.readInt()
    //        var m = row-1
    //        var space: Int = 0
    //        var n = 1
    //        var col: Int = 1
    //        for (n <- 1 to row) {
    //          col = 2 * n - 1
    //          for (space <- 1 to m) {
    //            print(" ")
    //          }
    //          for (n <- 1 to col) {
    //            print("*")
    //          }
    //          m -= 1
    //          println()
    //        }

    //    //while
    //    print("行数：")
    //    val row: Int = StdIn.readInt()
    //        var m: Int = row - 1
    //        var n: Int = 1
    //        var o: Int = 1
    //        var space: Int = 1
    //        var col: Int = 1
    //        while (n <= row) {
    //          col = 2 * n - 1
    //          while (space <= m) {
    //            print(" ")
    //            space += 1
    //          }
    //          while (o <= col) {
    //            print("*")
    //            o += 1
    //          }
    //          o = 1
    //          space = 1
    //          m -= 1
    //          n += 1
    //          println()
    //        }

    //    //作业12: 求1-100奇数的和
    //    //for
    //        var n:Int = 0
    //        var sum:Int = 0
    //        for(n<- 0 to 100){
    //          if(n%2==1){
    //            sum+=n
    //          }
    //        }
    //        print(sum)

    //    //while
    //        var n:Int = 0
    //        var sum:Int = 0
    //        while(n<100){
    //          if(n%2==1){
    //            sum+=n
    //          }
    //          n+=1
    //        }
    //        print(sum)

    //        //作业13:将判断一个数是否是素数
    //        //for
    //        print("请输入一个整数：")
    //        var in = StdIn.readInt()
    //            var isPrime: Array[Boolean] = new Array[Boolean](100)
    //            for (i <- isPrime.indices) {
    //              isPrime(i) = true
    //            }
    //            for (i <- 2 until isPrime.length) {
    //              for (k <- 2 until isPrime.length) {
    //                if (i * k < isPrime.length) {
    //                  isPrime(i * k) = false
    //                }
    //              }
    //            }
    //            if (isPrime(in)) {
    //              print("是素数")
    //            } else {
    //              print("不是素数")
    //            }

    //    //while
    //    print("请输入一个整数：")
    //    var in = StdIn.readInt()
    //        var isPrime: Array[Boolean] = new Array[Boolean](100)
    //        var i = 0
    //        var j = 2
    //        var k = 2
    //        while (i < isPrime.length) {
    //          isPrime(i) = true
    //          i += 1
    //        }
    //        while (j < isPrime.length) {
    //          while (k < isPrime.length) {
    //            if (j * k < isPrime.length) {
    //              isPrime(j * k) = false
    //            }
    //            k += 1
    //          }
    //          k = 2
    //          j += 1
    //        }
    //        if(isPrime(in)){
    //          print("是素数")
    //        }else{
    //          print("不是素数")
    //        }
  }
}
