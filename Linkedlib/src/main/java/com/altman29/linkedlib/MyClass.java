package com.altman29.linkedlib;

public class MyClass {
    public static void main(String[] args) {
        LinkedListWithDummyHead<Integer> linkedList = new LinkedListWithDummyHead<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
//        System.out.println("----------------------------------a");
//        System.out.println(linkedList.getSize());
        linkedList.add(2, 666);
        System.out.println(linkedList);
//        System.out.println("----------------------------------a");


//        System.out.println("----------------------------------b");
//        System.out.println(linkedList.getSize());
        linkedList.remove(2);
        System.out.println(linkedList);
//        System.out.println("----------------------------------b");


//        System.out.println("----------------------------------c");
//        System.out.println(linkedList.getSize());
        linkedList.removeFirst();
        System.out.println(linkedList);
//        System.out.println("----------------------------------c");


//        System.out.println("----------------------------------d");
//        System.out.println(linkedList.getSize());
        linkedList.removeLast();
        System.out.println(linkedList);
//        System.out.println("----------------------------------d");


    }


    public void printWithFlag() {


        System.out.println("----------------------------------");
    }


}
