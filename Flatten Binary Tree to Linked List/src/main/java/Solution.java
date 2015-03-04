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
        n2.right = n4;
        n3.left = n5;

        Solution s = new Solution();
        s.flatten(n1);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null && current.right != null) {
                s.push(current.right);
            }
            if (current.left != null) {
                current.right = current.left;
                current.left = null;
                current = current.right;
            }
            else {
                if (current.right == null) {
                    if (!s.isEmpty()) {
                        TreeNode next = s.pop();
                        current.right = next;
                        current = next;
                    }
                    else {
                        current = null;
                    }
                }
                else {
                    current = current.right;
                }
            }
        }
    }
}