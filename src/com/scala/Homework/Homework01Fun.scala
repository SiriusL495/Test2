package com.scala.Homework

import scala.io.StdIn

object Homework01Fun {
  def main(args: Array[String]): Unit = {

    //作业1：完成自己的学号、班级、姓名、指导老师的信息打印
    //    T1("zhangsan","1525245","1609","lisi")

    //作业2：给定任意0～9999的数字，分别打印出其各个位的数字。
    //    print("输入4位以内的数字：")
    //    val num:String = StdIn.readLine()
    //    T2(num)

    //作业3:十进制数转换为二进制数的方法
    //    printf("请输入一个整数：")
    //    val num = StdIn.readInt()
    //    T3(num)

    //作业4：在Linux下的权限，分为读，写，执行。分别对应4(100)，2(010)，1(001)。那么任意给一个0～7的数字，计算出该数字具有的权限。
    //    print("请输入权限(0-7的整数):")
    //    var n:Int = StdIn.readInt()
    //    T4(n)

    //作业5：用Scala写一段代码，判断输入的一个年份是否是闰年
    //    print("请输入年份：")
    //    var n: Int = StdIn.readInt()
    //    T5(n)

    //作业6：定义三个整数，要求按照从小到大的顺序输出
    //    println("请输入三个整数：")
    //    var a:Int = StdIn.readInt()
    //    var b:Int = StdIn.readInt()
    //    var c:Int = StdIn.readInt()
    //    T6(a,b,c)

    //作业7：给定一个x的值，求y的值，并将y的结果输出
    //    print("请输入x：")
    //    var x: Int = StdIn.readInt()
    //    T7(x)

    //作业8：：1～100偶数的和。
    //    T8_for()
    //    T8_while()

    //作业9：1～100的和。
    //    T9_for()
    //    T9_while()

    //作业10:打印图形：(n行)
    //    print("行数：")
    //    var a: Int = StdIn.readInt()
    //    T10_for(a)
    //    T10_while(a)

    //作业11:打印等腰三角形：(n行)
    //    print("行数：")
    //    val row: Int = StdIn.readInt()
    //    T11_for(row)
    //    T11_while(row)

    //作业12: 求1-100奇数的和
    //    T12_for()
    //    T12_while()

    //作业13:将判断一个数是否是素数
    //    print("请输入一个100以内的整数：")
    //    var in = StdIn.readInt()
    //    T13_for(in)
    //    T13_while(in)
  }

  def T1(name: String, no: String, classNo: String, teacher: String): Unit = {
    printf("姓名：%s\n学号：%s\n班级：%s\n指导老师：%s", name, no, classNo, teacher)
  }

  def T2(num: String): Unit = {
    val length: Int = num.length()
    length match {
      case 0 => println(0, 0, 0, 0)
      case 1 => println(0, 0, 0, num(0))
      case 2 => println(0, 0, num(0), num(1))
      case 3 => println(0, num(0), num(1), num(2))
      case 4 => println(num(0), num(1), num(2), num(3))
    }
  }

  def T3(num: Int): Unit = {
    println(num.toBinaryString)
  }

  def T4(n: Int): Unit = {
    var str: String = ""
    var r: String = ""
    var w: String = ""
    var x: String = ""
    val num = n
    var m = n
    while (m != 0) {
      str = m % 2 + str
      m = m / 2
    }
    if (str.length == 1) {
      str = "00" + str
    }
    if (str.length == 2) {
      str = "0" + str
    }
    if (str(0).toString.equals("1")) {
      r = " 读 "
    }
    if (str(1).toString.equals("1")) {
      w = " 写 "
    }
    if (str(2).toString.equals("1")) {
      x = " 执行 "
    }
    println("您的权限为：" + num + "(" + str + ")")
    println("您具有" + r + w + x + "的权限")
  }

  def T5(n: Int): Unit = {
    if ((n % 4) == 0 && (n % 400) == 0 && (n % 3200) != 0) {
      printf(n + "年是闰年")
    } else {
      printf(n + "年不是闰年")
    }
  }

  def T6(x: Int, y: Int, z: Int): Unit = {
    var a = x
    var b = y
    var c = z
    var t: Int = 0
    if (a >= b) {
      t = a
      a = b
      b = t
    }
    if (a >= c) {
      t = a
      a = c
      c = t
    }
    if (b >= c) {
      t = b
      b = c
      c = t
    }
    print(a, b, c)
  }

  def T7(x: Int): Unit = {
    var y: Int = 10
    if (x > 0) {
      y = 1
    }
    if (x == 0) {
      y = 0
    }
    if (x < 0) {
      y = -1
    }
    print(y)
  }

  def T8_for(): Unit = {
    var n: Int = 1
    var sum: Int = 0
    for (n <- 1 to 100) {
      if (n % 2 == 0) {
        sum = sum + n
      }
    }
    print(sum)
  }

  def T8_while(): Unit = {
    var n: Int = 1
    var sum: Int = 0
    while (n <= 100) {
      if (n % 2 == 0) {
        sum = sum + n
      }
      n += 1
    }
    print(sum)
  }

  def T9_for(): Unit = {
    var n: Int = 0
    var sum: Int = 0
    for (n <- 0 to 100) {
      sum += n
    }
    print(sum)
  }

  def T9_while(): Unit = {
    var n: Int = 0
    var sum: Int = 0
    while (n <= 100) {
      sum += n
      n += 1
    }
    print(sum)
  }

  def T10_for(a: Int): Unit = {
    var b: Int = 1
    var n: Int = 1
    for (n <- 1 to a) {
      for (n <- 1 to b) {
        print("*")
      }
      b += 1
      println()
    }
  }

  def T10_while(a: Int): Unit = {
    var b: Int = 1
    var n: Int = 1
    var m: Int = 1
    while (n <= a) {
      while (m <= b) {
        print("*")
        m += 1
      }
      n += 1
      b += 1
      m = 1
      println()
    }

  }

  def T11_for(row: Int): Unit = {
    var m = row - 1
    var space: Int = 0
    var n = 1
    var col: Int = 1
    for (n <- 1 to row) {
      col = 2 * n - 1
      for (space <- 1 to m) {
        print(" ")
      }
      for (n <- 1 to col) {
        print("*")
      }
      m -= 1
      println()
    }
  }

  def T11_while(row: Int): Unit = {
    var m: Int = row - 1
    var n: Int = 1
    var o: Int = 1
    var space: Int = 1
    var col: Int = 1
    while (n <= row) {
      col = 2 * n - 1
      while (space <= m) {
        print(" ")
        space += 1
      }
      while (o <= col) {
        print("*")
        o += 1
      }
      o = 1
      space = 1
      m -= 1
      n += 1
      println()
    }
  }

  def T12_for(): Unit = {
    var n: Int = 0
    var sum: Int = 0
    for (n <- 0 to 100) {
      if (n % 2 == 1) {
        sum += n
      }
    }
    print(sum)
  }

  def T12_while(): Unit = {
    var n: Int = 0
    var sum: Int = 0
    while (n < 100) {
      if (n % 2 == 1) {
        sum += n
      }
      n += 1
    }
    print(sum)
  }

  def T13_for(in: Int): Unit = {
    var isPrime: Array[Boolean] = new Array[Boolean](100)
    for (i <- isPrime.indices) {
      isPrime(i) = true
    }
    for (i <- 2 until isPrime.length) {
      for (k <- 2 until isPrime.length) {
        if (i * k < isPrime.length) {
          isPrime(i * k) = false
        }
      }
    }
    if (isPrime(in)) {
      print("是素数")
    } else {
      print("不是素数")
    }

  }

  def T13_while(in: Int): Unit = {
    var isPrime: Array[Boolean] = new Array[Boolean](100)
    var i = 0
    var j = 2
    var k = 2
    while (i < isPrime.length) {
      isPrime(i) = true
      i += 1
    }
    while (j < isPrime.length) {
      while (k < isPrime.length) {
        if (j * k < isPrime.length) {
          isPrime(j * k) = false
        }
        k += 1
      }
      k = 2
      j += 1
    }
    if (isPrime(in)) {
      print("是素数")
    } else {
      print("不是素数")
    }
  }
}
