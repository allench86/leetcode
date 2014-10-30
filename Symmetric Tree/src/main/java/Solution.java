import java.util.Stack;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftTree = new Stack<TreeNode>();
        Stack<TreeNode> rightTree = new Stack<TreeNode>();

        if (root != null) {
            TreeNode l, r;
            leftTree.push(root.left);
            rightTree.push(root.right);

            do {
                l = leftTree.pop();
                r = rightTree.pop();
                if (l == null && r == null) {
                    continue;
                }
                else if (l != null && r != null && l.val == r.val) {
                    leftTree.push(l.right);
                    leftTree.push(l.left);

                    rightTree.push(r.left);
                    rightTree.push(r.right);
                }
                else {
                    return false;
                }

            } while (!leftTree.isEmpty() && !rightTree.isEmpty());

        }

        return true;
    }
}