package com.scala.Homework;

import java.util.*;

public class Homework09_Java {
    public static void main(String[] args) {
        T1();
        T2();
        T3();
        T4();

    }

    public static void T1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();
        System.out.println("输入的字符串是：  " + str);
        char[] ch = str.toCharArray();


        Set s1 = new HashSet();
        Set s2 = new HashSet();
        Set s3 = new HashSet();
        for (Object obj : ch) {
            boolean falg = s1.add(obj);
            if (falg == false) {
                s2.add(obj);
            }

        }
        s3.addAll(s1);
        s3.removeAll(s2);
        System.out.println("去掉重复后的字符串");
        System.out.println(s1);
        System.out.println("重复的字符串是");
        System.out.println(s2);
        System.out.println("不重复的字符串是");
        System.out.println(s3);
    }

    public static void T2() {
        ArrayList list = new ArrayList<Student>();
        list.add(new Student("zhangsan", "english", 90));
        list.add(new Student("lisi", "english", 70));
        list.add(new Student("wangwu", "english", 50));
        for (int i = 0; i < list.size(); i++) {
            Student s = (Student) list.get(i);
            System.out.println(s);
        }
    }

    public static void T3() {

        String s = "55451684768764264";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int count = map.get(s.charAt(i));
                count++;
                map.put(s.charAt(i), count);
            }

        }
        System.out.println(map);
    }

    public static void T4() {
        String temp = "asda,asda,ddda,dda,daa,add,da,dda,dda,da,da,da";
        Map maps = new HashMap();
        String[] templist = temp.split(",");
        for (int i = 0; i < templist.length; i++) {
            String t = templist[i];
            boolean is = maps.containsKey(t);
            if (is == true) {
                Integer vs = (Integer) maps.get(t);
                vs++;
                maps.put(t, vs);
            } else {
                maps.put(t, 1);
            }
        }
        System.out.println(maps);

    }

}
