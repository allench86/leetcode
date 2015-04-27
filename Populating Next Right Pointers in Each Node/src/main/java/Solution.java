public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connectToRight(root, null);
    }

    private void connectToRight(TreeLinkNode curr, TreeLinkNode currRightSibling) {
        if (curr == null) {
            return;
        }

        curr.next = currRightSibling;

        if (curr.left != null) {
            curr.left.next = curr.right;
        }

        connectToRight(curr.left, curr.right);

        TreeLinkNode rightChildSibling = null;
        if (currRightSibling != null) {
            rightChildSibling = currRightSibling.left;
        }

        connectToRight(curr.right, rightChildSibling);

    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}