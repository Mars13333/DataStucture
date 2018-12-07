package com.altman29.linkedlib.make_stack.fromstack;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
