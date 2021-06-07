package com.fly.ftx.swordOffer.questions;

/**
 * 第六题
 */
public class Q06 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        if (head == null)
            return new int[0];
        int count = 1;
        while (node.next != null) {
            ++count;
            node = node.next;
        }
        int[] result = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = node.val;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
