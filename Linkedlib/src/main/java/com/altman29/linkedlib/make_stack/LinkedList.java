package com.altman29.linkedlib.make_stack;

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

    private Node dummyHead;//head头
    private int size;//链表中有多少个元素    private

    public LinkedList() {
        dummyHead = new Node(null, null);
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

//        head = new Node(e, head);

        add(0, e);
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
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;//prev一直向前移动，直到index之前的一个位置
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);

        size++;

    }

    /**
     * 在链表的末尾添加一个元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习使用
     */
    public E get(int index) {
        //判断index合法性
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index");

        Node cur = dummyHead.next;//current 当前的 与add中的循环不一样，从虚拟头元素的下个实际头进行遍历
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素e
     * 在链表中不是一个常用的操作，练习使用。
     */
    public void set(int index, E e) {
        //判断index合法性
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在e
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {//cur！=null 为有效节点
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素，返回删除的元素
     * 在链表中不是一个常用操作，练习使用
     *
     * @return
     */
    public E remove(int index) {
        //判断index合法性
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;//保存要删除的元素
        prev.next = retNode.next;//要删除的元素的前一个元素指向要删除的元素的下一个元素
        retNode.next = null;//要删除的元素的向后指引为空
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur=dummyHead;cur!=null;cur=cur.next)
        res.append("NULL");
        return res.toString();
    }


}
