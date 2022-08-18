package middle;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

public class SumTwoNumbers {

    public static void main(String[] args) {

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = new ListNode();
        head.next = result;
        ListNode prev = head;
        while (true) {
            if (l2 == null && l1 == null) {
                if (prev == head) {
                    return result;
                }
                if (result.val == 0) {
                    prev.next = null;
                }
                return head.next;
            }

            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int v = v1 + v2 + result.val;

            if (v >= 10) {
                v %= 10;
                result.next = new ListNode(1);
            } else {
                result.next = new ListNode();
            }

            result.val = v;
            prev = result;
            result = result.next;
        }
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;
   }
}
