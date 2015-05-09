import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return -1;
        }

        TreeNode curr = stack.pop();
        int value = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        return value;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
