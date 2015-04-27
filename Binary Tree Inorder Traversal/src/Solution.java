import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = s.new TreeNode(1);
        TreeNode n2 = s.new TreeNode(2);
        TreeNode n3 = s.new TreeNode(3);
        TreeNode n4 = s.new TreeNode(4);
        TreeNode n5 = s.new TreeNode(5);
        TreeNode n6 = s.new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(s.inorderTraversal(n1));

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }

        traversal(root, results);

        return results;
    }

    private void traversal(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }

        traversal(root.left, results);
        results.add(root.val);
        traversal(root.right, results);
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