public class Solution {
    public static void main(String[] args) {
        int[] input = { -84, 142, 41, -17, -71, 170, 186, 183, -21, -76, 76, 10, 29, 81, 112, -39, -6, -43, 58, 41,
                111, 33, 69, 97, -38, 82, -44, -7, 99, 135, 42, 150, 149, -21, -30, 164, 153, 92, 180, -61, 99, -81,
                147, 109, 34, 98, 14, 178, 105, 5, 43, 46, 40, -37, 23, 16, 123, -53, 34, 192, -73, 94, 39, 96, 115,
                88, -31, -96, 106, 131, 64, 189, -91, -34, -56, -22, 105, 104, 22, -31, -43, 90, 96, 65, -85, 184, 85,
                90, 118, 152, -31, 161, 22, 104, -85, 160, 120, -31, 144, 115 };

        ListNode head = buildList(input);

        Solution s = new Solution();
        ListNode newHead = s.insertionSortList(head);
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

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode j, p, q = null;
        j = new ListNode(-1);
        j.next = head;

        p = head;
        q = p.next;

        while (q != null) {
            if (p.val > q.val) {
                j.next = q;
                p.next = q.next;
                q.next = p;

                if (head == p) {
                    head = q;
                    j = j.next;
                    q = p.next;
                    continue;
                }

                ListNode k = head;
                ListNode l = new ListNode(-1);
                l.next = head;
                while (k.val < q.val) {
                    l = k;
                    k = k.next;
                }

                if (k != q) {
                    l.next = q;
                    j.next = q.next;
                    q.next = k;
                    if (head == k) {
                        head = q;
                    }
                    q = p.next;
                }
                else {
                    j = j.next;
                    q = p.next;
                }
            }
            else {
                j = j.next;
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }
}
