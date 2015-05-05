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
        System.out.println(s.isBalanced(n1));
    }

    public boolean isBalanced(TreeNode root) {
        boolean result = true;
        if (root != null) {
            int leftHeight = getHeight(root.left, 1);
            int rightHeight = getHeight(root.right, 1);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                result = false;
            }
            else {
                result = isBalanced(root.left) && isBalanced(root.right);
            }
        }

        return result;
    }

    public int getHeight(TreeNode root, int currentHeight) {
        if (root == null) {
            return currentHeight;
        }

        int leftHeight = getHeight(root.left, currentHeight + 1);
        int rightHeight = getHeight(root.right, currentHeight + 1);

        return Math.max(leftHeight, rightHeight);
    }
}