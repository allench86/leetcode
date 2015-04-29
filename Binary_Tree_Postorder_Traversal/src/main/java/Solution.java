import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            postOrder(result, root);
        }
        return result;
    }

    private void postOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        if (root.left != null) {
            postOrder(result, root.left);
        }

        if (root.right != null) {
            postOrder(result, root.right);
        }

        result.add(root.val);
    }
}