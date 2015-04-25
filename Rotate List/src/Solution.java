//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();

        ListNode c = s.rotateRight(n1, 2000000000);
        while (c != null) {
            System.out.print(c.val + ", ");
            c = c.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }

        int t = k % length;

        if (t == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode x = dummy;
        ListNode y = head;
        ListNode z = dummy;

        while (t > 0) {
            z = z.next;
            t--;
        }

        while (z.next != null) {
            x = x.next;
            y = y.next;
            z = z.next;
        }

        if (x != dummy) {
            z.next = head;
            dummy.next = y;
            x.next = null;
        }
        else {
            z.next = head;
            y.next = null;
            dummy.next = z;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}