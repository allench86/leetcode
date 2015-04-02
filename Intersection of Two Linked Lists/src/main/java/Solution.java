public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        int ALength = 0;
        int BLength = 0;
        while (p != null) {
            p = p.next;
            ALength++;
        }
        while (q != null) {
            q = q.next;
            BLength++;
        }
        int lengthDiff = Math.abs(ALength - BLength);
        p = headA;
        q = headB;
        if (ALength > BLength) {
            while (lengthDiff > 0) {
                p = p.next;
                lengthDiff--;
            }
        }
        else if (BLength > ALength) {
            while (lengthDiff > 0) {
                q = q.next;
                lengthDiff--;
            }
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
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