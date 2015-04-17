public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode i = tempHead;
        ListNode p = head;
        ListNode q = p.next;

        while (p != null && q != null) {
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                i.next = q;
                p = q;
                if (q != null) {
                    q = q.next;
                }
            }
            else {
                i = i.next;
                p = p.next;
                q = q.next;
            }
        }

        return tempHead.next;
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
