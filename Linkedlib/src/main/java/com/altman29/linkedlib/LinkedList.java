package com.altman29.linkedlib;

/**
 * Created by Csy on 2018/12/7.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc: 链表
 */
public class LinkedList<E> {

    /**
     * 节点设计成私用的内部类Node.私有的 内部类。 不需要暴露链表的底层实现，所以这也设计。
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;//head头
    private int size;//链表中有多少个元素    private

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);

        size++;
    }

    /**
     * 在链表的中间添加元素
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习思路用。
     */
    public void add(int index, E e) {
        //判断index合法性
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index");
        if (index == 0)//头节点需要一个特殊的处理，若使用虚拟头结点则可以优化 见 LinkedListWithDummyHead
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;//prev一直向前移动，直到index-1的位置
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);

            size++;
        }
    }

    /**
     * 在链表的末尾添加一个元素
     */
    public void addLast(E e) {
        add(size, e);
    }

}
