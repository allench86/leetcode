public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeLinkNode n1 = new TreeLinkNode(2);
        TreeLinkNode n2 = new TreeLinkNode(1);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(0);
        TreeLinkNode n5 = new TreeLinkNode(7);
        TreeLinkNode n6 = new TreeLinkNode(9);
        TreeLinkNode n7 = new TreeLinkNode(1);
        TreeLinkNode n8 = new TreeLinkNode(2);
        TreeLinkNode n9 = new TreeLinkNode(1);
        TreeLinkNode n10 = new TreeLinkNode(0);
        TreeLinkNode n11 = new TreeLinkNode(8);
        TreeLinkNode n12 = new TreeLinkNode(8);
        TreeLinkNode n13 = new TreeLinkNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n10.left = n13;

        s.connect(n1);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connectToRight(root);
    }

    private void connectToRight(TreeLinkNode curr) {
        if (curr == null) {
            return;
        }

        if (curr.left != null) {
            if (curr.right != null) {
                curr.left.next = curr.right;
            }
            else {
                TreeLinkNode sibling = curr.next;
                while (sibling != null && sibling.left == null && sibling.right == null) {
                    sibling = sibling.next;
                }
                if (sibling != null) {
                    if (sibling.left != null) {
                        curr.left.next = sibling.left;
                    }
                    else if (sibling.right != null) {
                        curr.left.next = sibling.right;
                    }
                }
            }
        }

        if (curr.right != null) {
            TreeLinkNode sibling = curr.next;
            while (sibling != null && sibling.left == null && sibling.right == null) {
                sibling = sibling.next;
            }
            if (sibling != null) {
                if (sibling.left != null) {
                    curr.right.next = sibling.left;
                }
                else if (sibling.right != null) {
                    curr.right.next = sibling.right;
                }
            }
        }

        // Important to process right subtree first, else case
        // [2, 1, 3, 0, 7, 9, 1, 2, #, 1, 0, #, #, 8, 8, #, #, #, #, 7]
        // will fail
        connectToRight(curr.right);
        connectToRight(curr.left);
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}