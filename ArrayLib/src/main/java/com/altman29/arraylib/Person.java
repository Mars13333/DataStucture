package com.altman29.arraylib;

/**
 * Created by Csy on 2018/11/20.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:测试使用泛型
 */
public class Person {

    private String name;
    private int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Person> array = new Array<>();
        array.addLast(new Person("jack", 99));
        array.addLast(new Person("jery", 91));
        array.addLast(new Person("staten", 78));

        ;

        System.out.println(array.toString());
    }
}
