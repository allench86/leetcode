public class Solution {
    private ListNode getLeftNodes(ListNode head) {
        ListNode fast = head;
        ListNode current = head;
        ListNode slow = current;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = current;
            current = current.next;
        }
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode leftEnd = getLeftNodes(head);
        ListNode mid = leftEnd.next;
        TreeNode currentRoot = new TreeNode(mid.val);
        leftEnd.next = null;
        currentRoot.left = sortedListToBST(head);
        currentRoot.right = sortedListToBST(mid.next);

        return currentRoot;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}