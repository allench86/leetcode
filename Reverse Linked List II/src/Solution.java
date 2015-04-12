//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode preM = new ListNode(-1);
        preM.next = head;

        ListNode pm = preM;
        ListNode pn = preM;
        ListNode postM = pm.next;
        for (int i = 0; i < m; i++) {
            preM = pm;
            pm = postM;
            if (postM != null) {
                postM = postM.next;
            }
        }

        for (int i = 0; i < n; i++) {
            pn = pn.next;
        }

        while (pm != pn) {
            preM.next = pn;
            pm.next = pn.next;
            pn.next = pm;
            pm = postM;
            postM = postM.next;
        }

        if (m == 1) {
            head = preM.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
