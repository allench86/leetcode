public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)
                || (p.left == null && q.left != null) || (p.left != null && q.left == null)
                || (p.right == null && q.right != null) || (p.right != null && q.right == null)) {
            return false;
        }
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * Definition for binary tree
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
