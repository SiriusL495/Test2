package com.spark.Homework.Homework01;

import java.util.Arrays;

public class LambdaDemo {
    public static void execute(Execute execute) {
        execute.doExecute();
    }

    public static void execute(Execute execute, String umpKey) {
        System.out.println("start========" + umpKey);
        try {
            execute.doExecute();
        } catch (Exception e) {
            System.out.println("umpKey===>" + umpKey);
        }
        System.out.println("end========" + umpKey);
    }


    private interface Execute {
        void doExecute();
    }

    //测试匿名内部类的使用方式
    public static void main(String[] args) {
        LambdaDemo.execute(() -> Study.print());
        LambdaDemo.execute(() -> Study.print(), "xxx");

        //测试数组的输出
        String[] profiles = {"xxx", "yyyyy", "zzzzzzzzzzzz"};
        String profilesStr = Arrays.stream(profiles).reduce((a, b) -> a + ", " + b).get();
        System.out.println(profilesStr + "=======\n" + Arrays.toString(profiles));

    }

    public static class Study {
        public static void print() {
            System.out.println("Hello world*******");
        }
    }
}
