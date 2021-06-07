package com.fly.ftx.swordOffer.questions;/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution18 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 还方法鲁棒性还是很好的
     * 几个点要注意：
     *  TODO:
     *    1. 链表为空
     *    2. 删除的是头节点
     *    3. 链表中只有一个节点，并且删除的是该节点
     *    4. 删除的是尾节点
     *    5. 只用一个辅助空间，就是不设置前驱节点来完成
     * @Problem TODO:
     * @Author fly-ftx
     * @Date 23:23 2021/5/18
     * @Param [head, val]
     * @return Offer.Solution18.ListNode
     **/
    // 该方法就是只用了要给空间的做法，就是通过比较当前节点的下一个节点，把当前节点作为前驱节点来完成删除
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null ) return null;
        if(head.next == null && head.val == val) return head=null;
        // 这里是细节
        ListNode current = head;
        // 不是头节点，那以后返回的都是头节点
        if(head.val == val) {
            return head.next;
        }
        while(current.next !=null) {
            // 删除的是尾节点
            if(current.next.val == val && current.next.next==null) {
                current.next = null;
                return head;
            }
            // 删除的不是尾节点
            if(current.next.val == val) {
                current.next = current.next.next;
                return head;
            }

            current = current.next;
        }
        return null;
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            ListNode ret = new Solution18().deleteNode(head, val);
            String out = listNodeToString(ret);
            System.out.print(out);
        }
    }
}

