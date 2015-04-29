import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            do {
                while (root != null) {
                    if (root.right != null) {
                        stack.push(root.right);
                    }
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                if (root.right != null && !stack.isEmpty() && root.right == stack.peek()) {
                    stack.pop();
                    stack.push(root);
                    root = root.right;
                }
                else {
                    result.add(root.val);
                    root = null;
                }

            } while (!stack.isEmpty());

        }

        return result;
    }
}