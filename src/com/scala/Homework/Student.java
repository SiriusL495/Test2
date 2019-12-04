package com.scala.Homework;

public class Student {
    private String name;
    private String cname;
    private double grade;

    public Student(String name, String cname, double grade) {
        this.name = name;
        this.cname = cname;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", cname='" + cname + '\'' + ", grade=" + grade;
    }
}
