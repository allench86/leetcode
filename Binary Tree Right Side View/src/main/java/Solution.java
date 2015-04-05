import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> results = new ArrayList<Integer>();
        if (root != null) {
            q.add(root);
            int currentLayerNum = q.size();

            while (currentLayerNum != 0) {
                TreeNode currentNode = q.poll();
                currentLayerNum--;
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
                if (currentLayerNum == 0) {
                    results.add(currentNode.val);
                    currentLayerNum = q.size();
                }
            }
        }

        return results;
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