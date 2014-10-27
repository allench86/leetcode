public class Solution {
    public static void main(String[] args) {
        int[] input1 = { 1, 5, 8 };
        ListNode l1 = buildList(input1);

        int[] input2 = { 2, 6 };
        ListNode l2 = buildList(input2);

        Solution s = new Solution();
        // s.reorderList(head);
        ListNode newHead = s.mergeTwoLists(l1, l2);
        while (newHead != null) {
            System.out.print(newHead.val + ",");
            newHead = newHead.next;
        }

    }

    private static ListNode buildList(int[] input) {
        ListNode head = null;
        if (input.length > 0) {
            head = new ListNode(input[0]);
        }
        ListNode next = head;
        for (int i = 1; i < input.length; i++) {
            next.next = new ListNode(input[i]);
            next = next.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode tempHeadNode = new ListNode(-1);
        ListNode t = tempHeadNode;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                t.next = p;
                p = p.next;
            }
            else {
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }

        while (p != null) {
            t.next = p;
            p = p.next;
            t = t.next;
        }

        while (q != null) {
            t.next = q;
            q = q.next;
            t = t.next;
        }

        return tempHeadNode.next;
    }
}
