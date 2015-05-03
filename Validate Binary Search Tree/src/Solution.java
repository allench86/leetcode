import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> results = new ArrayList<Integer>();

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
        boolean result = true;
        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) <= results.get(i - 1)) {
                return false;
            }
        }
        return result;

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
