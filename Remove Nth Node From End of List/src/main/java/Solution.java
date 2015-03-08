public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;

        Solution s = new Solution();

        ListNode r = s.removeNthFromEnd(n1, 2);

        ListNode p = r;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode end = head;
        ListNode nthFromEnd = head;
        ListNode pre = null;

        for (int i = 0; i < n - 1; i++) {
            end = end.next;
        }

        if (end.next == null) {
            head = head.next;
            nthFromEnd.next = null;
            return head;
        }

        while (end.next != null) {
            end = end.next;
            pre = nthFromEnd;
            nthFromEnd = nthFromEnd.next;
        }

        pre.next = nthFromEnd.next;
        nthFromEnd.next = null;

        return head;
    }

}
