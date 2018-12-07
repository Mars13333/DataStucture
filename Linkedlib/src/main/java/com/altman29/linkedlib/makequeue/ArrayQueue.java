package com.altman29.linkedlib.makequeue;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> mArray;

    public ArrayQueue(int capacity) {
        mArray = new Array<>(capacity);
    }

    public ArrayQueue() {
        mArray = new Array<>();
    }

    public int getCapacity() {
        return mArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: ");
        builder.append("队首 front [");
        for (int i = 0; i < mArray.getSize(); i++) {
            builder.append(mArray.get(i));
            if (i != mArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] tail 队尾");
        return builder.toString();
    }

    @Override
    public void enqueue(E e) {
        mArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return mArray.removeFirst();
    }

    @Override
    public E getFront() {
        return mArray.getFirst();
    }

    @Override
    public int getSize() {
        return mArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return mArray.isEmpty();
    }
}
