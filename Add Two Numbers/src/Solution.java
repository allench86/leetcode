//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);

        ListNode p = l1;
        ListNode q = l2;
        int f = 0;
        ListNode curr = dummy;

        while (p != null && q != null) {
            int value = f + p.val + q.val;
            f = value / 10;
            value %= 10;
            curr.next = new ListNode(value);
            p = p.next;
            q = q.next;
            curr = curr.next;
        }

        ListNode rest = p;
        if (q != null) {
            rest = q;
        }

        while (rest != null) {
            int value = f + rest.val;
            f = value / 10;
            value %= 10;
            curr.next = new ListNode(value);
            rest = rest.next;
            curr = curr.next;
        }

        if (f != 0) {
            curr.next = new ListNode(f);
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
