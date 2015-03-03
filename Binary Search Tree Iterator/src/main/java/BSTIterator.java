import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {
    private final List<Integer> results;
    private final int length;
    private int index;

    public BSTIterator(TreeNode root) {
        this.results = inorderTraversal(root);
        this.length = this.results.size();
        this.index = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index < this.length;
    }

    /** @return the next smallest number */
    public int next() {
        return this.results.get(this.index++);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode = root;

        while (!s.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                TreeNode t = s.pop();
                results.add(t.val);
                currentNode = t.right;
            }
        }

        return results;
    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new BSTIterator(root); while (i.hasNext()) v[f()] =
 * i.next();
 */
