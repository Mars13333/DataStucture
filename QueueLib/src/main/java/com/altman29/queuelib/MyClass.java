package com.altman29.queuelib;

import com.altman29.queuelib.array_queue.ArrayQueue;

public class MyClass {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {//每插入队列三个元素就出队一个
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
