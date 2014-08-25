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
        ListNode tempHead = head;
        ListNode newEnd = head;
        while (newEnd != null && newEnd.next != null) {
            newEnd = newEnd.next;
        }

        while (tempHead.next != null) {
            newEnd = reverseList(tempHead, tempHead.next, newEnd);
            tempHead = tempHead.next;
        }
    }

    public ListNode reverseList(ListNode head, ListNode startNode, ListNode end) {
        ListNode newEnd = startNode;

        head.next = end;
        end.next = startNode;

        while (startNode.next != end) {
            ListNode temp = startNode.next;
            startNode.next = end.next;
            end.next = startNode;
            startNode = temp;
        }

        startNode.next = end.next;
        end.next = startNode;
        newEnd.next = null;

        return newEnd;
    }
}
