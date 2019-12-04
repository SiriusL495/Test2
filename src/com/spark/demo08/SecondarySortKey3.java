package com.spark.demo08;

import java.io.Serializable;

public class SecondarySortKey3 implements Comparable<SecondarySortKey3>, Serializable {

    private int first;
    private int second;
    private int third;

    public SecondarySortKey3(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(SecondarySortKey3 other) {
        if (this.first - other.getFirst() != 0) {
            return this.first - other.getFirst();
        } else {
            if (this.second - other.getSecond() != 0) {
                return this.second - other.getSecond();
            } else {
                return this.third - other.getThird();
            }
        }
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }
}
