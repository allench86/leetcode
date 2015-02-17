import java.util.Stack;

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

    }

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode p = null, q = null, newRoot = null;
        if (root == null) {
            return null;
        }
        p = root;
        while (p.left != null) {
            parentStack.push(p);
            p = p.left;
        }
        newRoot = p;
        while (!parentStack.isEmpty()) {
            q = parentStack.pop();
            p.right = q;
            p.left = q.right;
            p = q;
        }
        p.left = null;
        p.right = null;
        return newRoot;
    }
}