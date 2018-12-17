package com.altman29.bstlib.BST;

/**
 * Created by Csy on 2018/12/17.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */
public class BST<E extends Comparable<E>> {

    /**
     * 节点
     */
    private class Node {
        public E e;
        public Node left, right;//左孩子，右孩子

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    /**
     * 存放了多少元素
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取bst大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * bst是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树添加新的元素e
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入元素E，递归算法
     * <p>
     * 递归算法的俩个步骤：
     * 1.递归终止条件    3个
     * 2.递归调用
     *
     * 这是复杂的 白话的写法。   帮助理解bst的递归写法。
     * @param node 不断的转换,逐渐变化
     * @param e
     */
    private void add(Node node, E e) {
        if (e.equals(node.e))//等于根节点
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {//小于根节点但是左子树为空
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {//大于根节点但是右子树为空
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else //e.compareTo(node.e)>0
            add(node.right, e);

    }
}
