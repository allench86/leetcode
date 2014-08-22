public class Solution {
    /**
     * Create an array, elements in the array are references to the node in the list. Do a quick sort on that array.
     * Then re-organize the list.
     */

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        Solution s = new Solution();
        ListNode newHead = s.sortList(n1);
        while (newHead != null) {
            System.out.print(newHead.val + ",");
            newHead = newHead.next;
        }

    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = null;
        int length = getLengthOfList(head);

        ListNode[] sortedList = new ListNode[length];

        int i = 0;
        ListNode p = head;
        while (p != null) {
            sortedList[i++] = p;
            p = p.next;
        }

        quickSort(sortedList, 0, sortedList.length - 1);

        i = 0;
        while (i < sortedList.length - 1) {
            p = sortedList[i];
            p.next = sortedList[i + 1];
            i++;
        }
        sortedList[sortedList.length - 1].next = null;
        newHead = sortedList[0];

        return newHead;
    }

    public void quickSort(ListNode[] list, int l, int h) {
        if (l < h && l >= 0 && h < list.length) {
            int flagIndex = oneRunQuickSort(list, l, h);
            quickSort(list, l, flagIndex - 1);
            quickSort(list, flagIndex + 1, h);
        }
    }

    private int oneRunQuickSort(ListNode[] list, int l, int h) {
        ListNode flag = list[l];
        while (l < h) {
            while (l < h && list[h].val > flag.val) {
                h--;
            }
            if (l != h) {
                list[l] = list[h];
                l++;
            }
            while (l < h && list[l].val < flag.val) {
                l++;
            }
            if (l != h) {
                list[h] = list[l];
                h--;
            }
        }
        list[l] = flag;
        return l;
    }

    private int getLengthOfList(ListNode head) {
        int l = 0;
        for (ListNode p = head; p != null; p = p.next) {
            l++;
        }
        return l;
    }
}
