//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode n1 = s.new ListNode(2);
        ListNode n2 = s.new ListNode(1);

        n1.next = n2;

        ListNode result = s.partition(n1, 1);
        ListNode c = result;
        while (c != null) {
            System.out.print(c.val + ", ");
            c = c.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessThanHead = new ListNode(-1);
        ListNode greaterThanHead = new ListNode(-1);
        ListNode lessThanEnd = lessThanHead;
        ListNode greaterThanEnd = greaterThanHead;

        ListNode currentNode = head;
        ListNode newListHead = head;

        if (head != null) {
            while (currentNode != null) {
                if (currentNode.val < x) {
                    lessThanEnd.next = currentNode;
                    lessThanEnd = lessThanEnd.next;
                    currentNode = currentNode.next;
                    lessThanEnd.next = null;
                }
                else if (currentNode.val >= x) {
                    greaterThanEnd.next = currentNode;
                    greaterThanEnd = greaterThanEnd.next;
                    currentNode = currentNode.next;
                    greaterThanEnd.next = null;
                }
            }
            lessThanEnd.next = greaterThanHead.next;
            newListHead = lessThanHead.next;
        }

        return newListHead;

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
