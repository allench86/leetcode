public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        Solution s = new Solution();
        System.out.println(s.sumNumbers(n1));
    }

    public int sumNumbers(TreeNode root) {
        int[] sum = { 0 };
        if (root != null) {
            generateSum(root, sum, 0);
        }

        return sum[0];
    }

    public void generateSum(TreeNode root, int[] sum, int preSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum[0] += preSum * 10 + root.val;
            return;
        }

        generateSum(root.left, sum, preSum * 10 + root.val);
        generateSum(root.right, sum, preSum * 10 + root.val);

    }
}