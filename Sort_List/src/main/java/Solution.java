public class Solution {
    /**
     * Using merge sort. Average and worst cases are all O(n log n) time.
     */

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();
        ListNode newHead = s.sortList(n1);
        while (newHead != null) {
            System.out.print(newHead.val + ",");
            newHead = newHead.next;
        }

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLengthOfList(head);
        return mergeSort(head, length);
    }

    public ListNode mergeSort(ListNode head, int length) {
        if (length == 1) {
            head.next = null;
            return head;
        }

        ListNode halfListHead = breakToHalf(head, length);

        ListNode list1 = mergeSort(head, length / 2);
        ListNode list2 = mergeSort(halfListHead, length - length / 2);

        return merge(list1, length / 2, list2, length - length / 2);
    }

    private ListNode breakToHalf(ListNode head, int length) {
        int halfLength = length / 2;
        while (halfLength > 1) {
            head = head.next;
            halfLength--;
        }
        ListNode next = head.next;
        head.next = null;
        head = next;
        return head;
    }

    public ListNode merge(ListNode list1, int length1, ListNode list2, int length2) {
        ListNode head = new ListNode(-1);
        ListNode end = head;
        while (length1 > 0 && length2 > 0) {
            if (list1.val <= list2.val) {
                end.next = list1;
                list1 = list1.next;
                length1--;
            }
            else {
                end.next = list2;
                list2 = list2.next;
                length2--;
            }
            end = end.next;
        }

        while (list1 != null) {
            end.next = list1;
            list1 = list1.next;
            end = end.next;
        }
        while (list2 != null) {
            end.next = list2;
            list2 = list2.next;
            end = end.next;
        }

        return head.next;
    }

    private int getLengthOfList(ListNode head) {
        int l = 0;
        for (ListNode p = head; p != null; p = p.next) {
            l++;
        }
        return l;
    }
}
