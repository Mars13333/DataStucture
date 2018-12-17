package com.altman29.linkedlib.solution203;

/**
 * Created by Csy on 2018/12/8.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        /*
        使用虚拟头结点
        统一逻辑，不在考虑是否是链表头元素，可以直接使用通用的一套逻辑
         */
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

//        /*
//        开始的位置是要删除的val
//         */
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        if (head == null)
//            return null;

        /*
        中间位置要删除的node
        使用虚拟头节点  可以通用这一套逻辑。
         */
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    class Solution3 {
        /**
         * 递归方式实现
         * 头节点+一个短一点的链表
         *
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return null;

            ListNode res = removeElements(head.next, val);//要删除的node
            if (head.val == val)//如果头节点的值等于目标值
                return res;//返回头节点
            else {
                head.next = res;//把头节点的next链接到后面
                return head;
            }
        }

        //简化版
        public ListNode removeElements1(ListNode head, int val) {
            if (head == null)
                return null;

            head.next = removeElements(head.next, val);//要删除的node
            return head.val == val ? head.next : head;

        }
    }
}