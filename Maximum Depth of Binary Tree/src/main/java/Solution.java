public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = s.new TreeNode(1);
        TreeNode n2 = s.new TreeNode(2);
        TreeNode n3 = s.new TreeNode(3);
        TreeNode n4 = s.new TreeNode(4);
        TreeNode n5 = s.new TreeNode(5);
        TreeNode n6 = s.new TreeNode(6);

        n1.left = n2;
        // n2.right = n3;
        // n3.left = n4;
        // n3.right = n5;
        // n4.left = n6;

        System.out.println(s.maxDepth(n1));
    }

    int maxDepth = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    private void depth(TreeNode root) {
        if (root == null) {
            return;
        }
        else {
            depth++;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            depth(root.left);
            depth(root.right);
            depth--;
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
