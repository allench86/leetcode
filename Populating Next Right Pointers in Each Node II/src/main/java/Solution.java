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
                if (currentParent.left != null && currentParent.right == null) {
                    TreeLinkNode next = currentParent.next;
                    while (next != null) {
                        if (next.left != null) {
                            currentParent.left.next = next.left;
                            break;
                        }
                        else if (next.right != null) {
                            currentParent.left.next = next.right;
                            break;
                        }
                        else {
                            currentParent.left.next = null;
                            next = next.next;
                        }
                    }
                }
                if (currentParent.right != null) {
                    TreeLinkNode next = currentParent.next;
                    while (next != null) {
                        if (next.left != null) {
                            currentParent.right.next = next.left;
                            break;
                        }
                        else if (next.right != null) {
                            currentParent.right.next = next.right;
                            break;
                        }
                        else {
                            currentParent.right.next = null;
                            next = next.next;
                        }
                    }
                }

                currentParent = currentParent.next;
            }
            if (headOfCurrentLavel.left != null) {
                currentParent = headOfCurrentLavel.left;
            }
            else if (headOfCurrentLavel.right != null) {
                currentParent = headOfCurrentLavel.right;
            }
            else {
                TreeLinkNode next = headOfCurrentLavel.next;
                while (next != null) {
                    if (next.left != null) {
                        currentParent = next.left;
                        break;
                    }
                    else if (next.right != null) {
                        currentParent = next.right;
                        break;
                    }
                    else {
                        currentParent = null;
                        next = next.next;
                    }
                }
            }
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