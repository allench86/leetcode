import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visitedNodes = new HashSet<TreeNode>();
        TreeNode currentNode = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            if (currentNode == null) {
                break;
            }
            if ((currentNode.left == null && currentNode.right == null) || visitedNodes.contains(currentNode)) {
                result.add(currentNode.val);
            }
            else {
                stack.push(currentNode);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                visitedNodes.add(currentNode);
            }
        }

        return result;
    }
}