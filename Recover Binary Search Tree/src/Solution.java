public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        TreeNode pre = null;
        TreeNode parent = null;
        boolean found = false;
        TreeNode p1 = null, p2 = null;

        while (current != null) {
            if (current.left == null) {
                // print current
                if (parent != null && parent.val > current.val) {
                    if (!found) {
                        p1 = parent;
                        found = true;
                    }
                    p2 = current;
                }
                parent = current;
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    // print current
                    pre.right = null;
                    if (parent.val > current.val) {
                        if (!found) {
                            p1 = parent;
                            found = true;
                        }
                        p2 = current;
                    }
                    parent = current;
                    parent = current;
                    current = current.right;
                }

            }
        }

        if (p1 != null && p2 != null) {
            int t = p1.val;
            p1.val = p2.val;
            p2.val = t;
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
