package com.altman29.queuelib;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public interface Queue<E> {
    /**
     * 入队 从队尾添加
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队  从队首取出
     * @return
     */
    E dequeue();

    /**
     * 获取队首
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
