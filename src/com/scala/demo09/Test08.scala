package com.scala.demo09

object Test08 {
  def main(args: Array[String]): Unit = {

    //map创建
    val map = Map("1"->"zhangsan","2"->"lisi","3"->"wangwu")

    //获取Map的值
    println(map("2"))
    println(map.getOrElse("1111","noValue"))

    //遍历
    for(x<-map){
      println("====key:"+x._1,"value:"+x._2)
    }
    map.foreach(x=>println("key:"+x._1+" value:"+x._2))

    //遍历Key
    val keyIterator = map.keys
    keyIterator.foreach(key=>println("key:"+key+",value:"+map(key)))

    //遍历value
    val valueIterator = map.values
    valueIterator.foreach(value=>println("value:"+value))

    //map合并
    val map1 = Map((1,"a"),(2,"b"),(3,"c"))
    val map2 = Map((1,"a"),(2,"b"),(3,"c"),(4,"d"))

    //map1加入map2中
    map1.++(map2).foreach(println)

    //map中方法举例
    println(map2.count(p=>p._2.equals("c")))

    //filter
    map2.filter(_._2.equals("d")).foreach(println)

    //contains
    println(map2.contains(2))

    //map操作：一对一的映射
    val scoreMap = Map("zhangsan"->30,"Jack"->59,"Tom"->70)
    val names = List("zhangsan","Tom","Jack")
    println(names.map(scoreMap(_)))

    //flatMap操作：一对多的映射
    val scoreMap2 = Map("zhangsan"->List(80,90,100),"Jack"->List(70,80,90),"Tom"->List(49,89,99))
    println(names.flatMap(scoreMap2(_)))//扁平化

  }
}
