public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode tempHeader = new ListNode(-1);
        ListNode i, j, k;
        if (head != null) {
            tempHeader.next = head;
            i = tempHeader;
            j = i.next;
            if (j != null) {
                k = j.next;

                while (k != null) {
                    i.next = k;
                    j.next = k.next;
                    k.next = j;

                    i = j;
                    j = i.next;
                    if (j != null) {
                        k = j.next;
                    }
                    else {
                        k = null;
                    }
                }

            }
        }

        ListNode newHead = tempHeader.next;

        return newHead;
    }
}