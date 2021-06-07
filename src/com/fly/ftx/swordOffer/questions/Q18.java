package com.fly.ftx.swordOffer.questions;
/**
 * 删除链表的节点
 */
public class Q18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode headResult = head;
        ListNode preNode = head;
        if(head ==null) return null;
        if(head.val == val) {
            headResult = head.next;
        }else{
            headResult = head;
        }
        while(head != null) {
            if(head.val != val){
                preNode = head;
                head = head.next;
            }else{
                preNode.next = head.next;
                head = head.next;
            }
        }
        return headResult;
    }
}
