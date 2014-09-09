import java.util.Stack;

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

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();

        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            Stack<TreeNode> temp = currentLevel;
            while (!currentLevel.isEmpty()) {
                TreeNode currentNode = currentLevel.pop();
                if (currentNode.left != null) {
                    nextLevel.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.push(currentNode.right);
                }
            }
            maxDepth++;
            currentLevel = nextLevel;
            nextLevel = temp;
        }

        return maxDepth;
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
