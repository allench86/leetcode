public class Solution {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6 };

        ListNode head = buildList(input);

        Solution s = new Solution();
        s.reorderList(head);
        ListNode newHead = head;
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        // split to two lists
        while (true) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }

        reverseList(slow, slow.next);
        ListNode halfHead = slow.next;
        slow.next = null;
        mergeLists(head, halfHead);

    }

    private void mergeLists(ListNode head, ListNode secondHead) {
        ListNode p = head, q = secondHead;
        ListNode t = null;
        while (q != null) {
            t = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = t;
        }
    }

    public void reverseList(ListNode pre, ListNode start) {
        ListNode t = null;
        while (start.next != null) {
            t = pre.next;
            pre.next = start.next;
            start.next = start.next.next;
            pre.next.next = t;
        }
    }

}
