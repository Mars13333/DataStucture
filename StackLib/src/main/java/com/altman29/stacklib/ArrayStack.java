package com.altman29.stacklib;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:    基于动态数组实现的栈   由于是基于动态数组实现的，所以容量也是可以动态扩容的 很方便
 */
public class ArrayStack<E> implements Stack<E> {

    //需要一个动态数组的成员变量
    Array<E> mArray;

    public ArrayStack(int capacity) {
        mArray = new Array<>(capacity);
    }

    public ArrayStack() {
        mArray = new Array<>();
    }

    /**
     * 栈的容量
     *
     * @return
     */
    public int getCapccity() {
        return mArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack: ");
        builder.append("[");
        for (int i = 0; i < mArray.getSize(); i++) {
            builder.append(mArray.get(i));
            if (i != mArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] top");
        return builder.toString();
    }

    ///实现接口  下面的

    @Override
    public int getSize() {
        return mArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return mArray.isEmpty();
    }

    @Override
    public void push(E e) {
        mArray.addLast(e);
    }

    @Override
    public E pop() {
        return mArray.removeLast();
    }

    @Override
    public E peek() {
        return mArray.getLast();
    }
}
