package com.sparkSQL.demo03;

import java.io.Serializable;

public class Person implements Serializable {
    public static String isPerson = "";
    public String id;
    public String name;
    public String age;

    public static String getIsPerson() {
        return isPerson;
    }

    public static void setIsPerson(String isPerson) {
        Person.isPerson = isPerson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
