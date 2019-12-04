package com.spark.demo08;

import scala.Serializable;
import scala.math.Ordered;

import java.util.Objects;


public class SecondarySortKey implements Ordered<SecondarySortKey>, Serializable {

    private int first;
    private int second;

    public SecondarySortKey() {

    }

    public SecondarySortKey(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compare(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " comparing to " + other.getSecond());
        if (this.first - other.getFirst() != 0) {
            return this.first - other.getFirst();
        } else {
            return this.second - other.getSecond();
        }
    }

    @Override
    public boolean $less(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " lessing to " + other.getSecond());
        if (this.first < other.getFirst()) {
            return true;
        } else return this.first == other.getFirst() && this.second < other.getSecond();
    }

    @Override
    public boolean $greater(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " greatering to " + other.getSecond());
        if (this.first > other.getFirst()) {
            return true;
        } else return this.first == other.getFirst() && this.second > other.getSecond();
    }

    @Override
    public boolean $less$eq(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " less equaling to " + other.getSecond());
        if (this.$less(other)) {
            return true;
        } else return this.first == other.getFirst() && this.second == other.getSecond();
    }

    @Override
    public boolean $greater$eq(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " greater equaling to " + other.getSecond());
        if (this.$greater(other)) {
            return true;
        } else return this.first == other.getFirst() && this.second == other.getSecond();
    }

    @Override
    public int compareTo(SecondarySortKey other) {
        System.out.println("-------- " + other.getFirst() + " compareToing to " + other.getSecond());
        if (this.first - other.getFirst() != 0) {
            return this.first - other.getFirst();
        } else {
            return this.second - other.getSecond();
        }
    }

    /**
     * 为了要进行排序的多个列
     * 提供getter，setter方法，以及hashCode的equals方法
     */

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

    public boolean equals(Object o) {
        System.out.println("----equals---- " + o);
        if (this == o) return true;
        if (!(o instanceof SecondarySortKey)) return false;
        SecondarySortKey that = (SecondarySortKey) o;
        return getFirst() == that.getFirst() && getSecond() == that.getSecond();
    }

    public int hashCode() {
        System.out.println("----hashcode---- ");
        return Objects.hash(getFirst(), getSecond());
    }

}
