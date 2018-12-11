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
}