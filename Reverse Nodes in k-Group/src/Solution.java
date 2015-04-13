public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = s.new ListNode(1);
        ListNode n2 = s.new ListNode(2);
        ListNode n3 = s.new ListNode(3);
        ListNode n4 = s.new ListNode(4);
        ListNode n5 = s.new ListNode(5);
        ListNode n6 = s.new ListNode(6);
        ListNode n7 = s.new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;

        int k = 2;
        ListNode newHead = s.reverseKGroup(n1, 3);

        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummyHead = pre;

        ListNode p = head;

        while (true) {
            for (int i = 0; i < k - 1; i++) {
                if (p == null) {
                    return dummyHead.next;
                }
                p = p.next;
            }
            if (p != null) {
                ListNode nextPre = pre.next;
                ListNode c = pre.next;
                ListNode pNext = c;
                ListNode post = p.next;

                for (int i = 0; i < k - 1; i++) {
                    pre.next = c.next;
                    pNext = p.next;
                    p.next = c;
                    c.next = pNext;
                    c = pre.next;
                }
                pre.next = p;
                p = post;
                pre = nextPre;
            }
            else {
                return dummyHead.next;
            }
        }
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
