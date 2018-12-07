package com.altman29.linkedlib.makequeue;

/**
 * Created by Csy on 2018/12/7.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    //入队  O(1)
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            //说明队列为空
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    //出队。O(1)
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("is Empty");

        //从链表头删除一个元素。
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("is Empty");

        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

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
