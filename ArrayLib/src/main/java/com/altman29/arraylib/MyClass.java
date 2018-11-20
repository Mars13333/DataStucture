package com.altman29.arraylib;

public class MyClass {
    public static void main(String[] args) {

//        int[] arr = new int[10];
//
//        //arr.length 数组长度
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//
//
//        //开辟成有三个int类型的数组
//        int[] scores = new int[]{100, 99, 66};
//        //打印
//        for (int i = 0; i < scores.length; i++) {
//            //访问
////            System.out.println(scores[i]);
//        }
//
//
//        //foreach
//        for (int score : scores) {
//            //访问
////            System.out.println(score);
//        }
//
//
//        //修改
//        scores[0] = 90;
//        for (int score : scores) {
//            System.out.println(score);
//        }


        //使用自己的数组

//        Array array = new Array(20);
//        for (int i = 0; i < 10; i++) {
//            array.addLast(i);
//        }
//        System.out.println(array);

//        array.add(1,100);
//
//        System.out.println(array);
//
//        array.addFirst(-1);
//
//        System.out.println(array);

//        int i = array.removeByIndex(9);
//        System.out.println(i);

//        System.out.println(array);

//        array.removeLast();
//        System.out.println(array);

        //使用泛型
        Array<Integer> arr = new Array<>(5);
        for (int i = 0; i < 5; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }
}
