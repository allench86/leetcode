public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        Solution s = new Solution();
        ListNode head = s.deleteDuplicates(n1);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode p = head;
            ListNode q = head.next;
            while (q != null) {
                if (p.val == q.val) {
                    p.next = q.next;
                    q = p.next;
                }
                else {
                    p = p.next;
                    q = q.next;
                }
            }
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
