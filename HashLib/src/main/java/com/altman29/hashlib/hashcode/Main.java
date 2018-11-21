package com.altman29.hashlib.hashcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public class Main {
    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());


        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(1, 2, "jack", "sms");

        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();//基于哈希表实现的集合
        set.add(student);//自动调用hashcode，计算出索引值，存储在对应的位置中。

        HashMap<Student, Integer> scores = new HashMap<>();//基于哈希表实现的映射
        scores.put(student, 100);

        //Object 本身有一个hashcode的实现，根据内存的地址，转换成一个索引


    }
}
