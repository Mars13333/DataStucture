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
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//
        /*
        因为新的add已经考虑了为null的逻辑，所以这里可以不用判断
         */
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E，递归算法
     * <p>
     * 递归算法的俩个步骤：
     * 1.递归终止条件    3个
     * 2.递归调用
     *
     * 这是复杂的 白话的写法。   帮助理解bst的递归写法。
     *
     * 俩个else if 条件臃肿，为null时应该直接插入
     * 俩轮compareTo 重复
     * 递归终止逻辑不一致。
     *
     * 1.
     * public void add 已经调用root是否为null的判断，根为null的话直接就是一个根节点，否则的话才调用递归的函数，
     * 在递归调用中，将这个新的元素作为Node的子节点插入进去的，这里就形成了逻辑上的不统一。
     * 其实这个函数的目的是，把一个新的Node插入给Node的左孩子或Node的右孩子 和递归有些冲突。
     *
     * 2.e和node.e俩轮比较，第一次看是否为null，然后插入，第二次直接调用add。条件十分臃肿。
     *
     * 而Null本身也是二叉树，Null的情况下就应该创建新节点，不管是否null再递归一层，这个位置本身就是这个节点。
     *
     * @param node 不断的转换,逐渐变化
     * @param e
     */
//    private void add(Node node, E e) {
//        if (e.equals(node.e))//等于根节点
//            return;
//        else if (e.compareTo(node.e) < 0 && node.left == null) {//小于根节点但是左子树为空
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {//大于根节点但是右子树为空
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else //e.compareTo(node.e)>0
//            add(node.right, e);
//
//    }

    /**
     * _向以node为根的二分搜索树中插入元素E，递归算法
     * -----返回插入新节点后二分搜索树的根。-----
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);//如果为null，直接返回给上层   返回插入新节点后二分搜索树的根。
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);//省略了==的情况

        return node;
    }


    /**
     * 查看二分搜索树中是否包含元素e
     * 递归的方式实现
     * 从根开始查找逐渐到子树查找的过程直到找到或者找不到元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查找的递归实现
     * 查看以node为根的二分搜索树中是否包含元素e的递归算法
     *
     * 从宏观的角度考虑contains的具体语意是什么 确定整体成立的逻辑
     * 从微观的角度具体的写几个元素更一下contains算法看方法是如何一步一步的得到结果的
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        //1.首先处理终止情况
        if (null == node) {
            //若节点为空 直接放回false
            return false;
        }

        if (e.compareTo(node.e) == 0)//compareTo==0 说明找到 直接返回true
            return true;
        else if (e.compareTo(node.e) < 0) {//compareTo<0 说明目标元素e在当前node的左子树中
            //所以响应的就去当前node的左子树中去找目标元素
            return contains(node.left, e);//递归左子树
        } else //e.compareTo(node.e)>0
            return contains(node.right, e);//递归右子树
    }


}
