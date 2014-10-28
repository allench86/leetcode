public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;

        Solution s = new Solution();
        s.isBalanced(n1);
    }

    public boolean isBalanced(TreeNode root) {
        boolean result = true;
        if (root != null) {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            System.out.println("l:" + leftHeight + " r:" + rightHeight);

            if (leftHeight == -1 || rightHeight == -1) {
                result = false;
            }
            else if (Math.abs(leftHeight - rightHeight) > 1) {
                result = false;
            }
        }

        return result;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}