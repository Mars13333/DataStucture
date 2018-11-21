package com.altman29.queuelib.loopqueue;


import com.altman29.queuelib.base.Queue;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:  循环队列   不使用Array  手写新的
 * 出队的时间复杂度  变为 O(1)
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;//数组
    private int front, tail;//队首、队尾
    private int size;//大小


    public LoopQueue(int capacity) {
        data = (E[]) (new Object[capacity + 1]);
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCatacity() {
        return data.length - 1;//因为循环队列有意识的浪费了一个空间
    }

    //入队
    @Override
    public void enqueue(E e) {
        //1.判断是否满
        if ((tail + 1) % data.length == front) {
            resize(getCatacity() * 2);//扩容
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;//需要%
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];//保存出队的元素
        data[front] = null;//出队，设为null
        front = (front + 1) % data.length;//维护front
        size--;//维护size
        if (size == getCatacity() / 4 && getCatacity() / 2 != 0) {//空间太大 缩容
            resize(getCatacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) (new Object[newCapacity + 1]);
        for (int i = 0; i < size; i++) {//第一种遍历的循环方式
            newData[i] = data[(i + front) % data.length];//若不是在数组0的位置，可能有front的偏移
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d ,capacity = %d\n", size, getCatacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {//第二种遍历循环的方式
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            } else {
                res.append("] tail");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {//每插入队列三个元素就出队一个
                queue.dequeue();
                System.out.println(queue);
            }
        }

        /* 日志如下：
        Queue: size = 1 ,capacity = 10
        front [0] tail
        Queue: size = 2 ,capacity = 10
        front [0, 1] tail
        Queue: size = 3 ,capacity = 10      入队三次
        front [0, 1, 2] tail
        Queue: size = 2 ,capacity = 5       出队一次    缩容
        front [1, 2] tail
        Queue: size = 3 ,capacity = 5
        front [1, 2, 3] tail
        Queue: size = 4 ,capacity = 5
        front [1, 2, 3, 4] tail
        Queue: size = 5 ,capacity = 5
        front [1, 2, 3, 4, 5] tail
        Queue: size = 4 ,capacity = 5
        front [2, 3, 4, 5] tail
        Queue: size = 5 ,capacity = 5
        front [2, 3, 4, 5, 6] tail
        Queue: size = 6 ,capacity = 10      扩容
        front [2, 3, 4, 5, 6, 7] tail
        Queue: size = 7 ,capacity = 10
        front [2, 3, 4, 5, 6, 7, 8] tail
        Queue: size = 6 ,capacity = 10
        front [3, 4, 5, 6, 7, 8] tail
        Queue: size = 7 ,capacity = 10
        front [3, 4, 5, 6, 7, 8, 9] tail
         */
    }
}
