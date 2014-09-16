public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        root.next = null;

        TreeLinkNode headOfCurrentLavel = root;
        TreeLinkNode currentParent = root;

        while (headOfCurrentLavel != null) {
            while (currentParent != null) {
                if (currentParent.left != null && currentParent.right != null) {
                    currentParent.left.next = currentParent.right;
                }
                if (currentParent.next == null && currentParent.right != null) {
                    currentParent.right.next = null;
                }
                else if (currentParent.next != null && currentParent.right != null) {
                    currentParent.right.next = currentParent.next.left;
                }
                currentParent = currentParent.next;
            }
            currentParent = headOfCurrentLavel.left;
            headOfCurrentLavel = currentParent;
        }
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}