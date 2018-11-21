package com.altman29.hashlib.hashcode;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;//进制，31随便写的
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();
        //一直加，可能产生整型的溢出。会转成最新的值。但是无所谓，还是在整型的范围呢。
        return hash;
    }

    /*
    Student作为"键"只复写一个hashCode是不够的。还需要equals 因为hashcode可能得到相同的值，需要equals再进行判断一次。
    当hashcode相同时，还会进行equals进行判断。
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Student another = (Student) o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
