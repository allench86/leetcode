import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        System.out.println(s.generateTrees(n).size());
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            List<TreeNode> results = new ArrayList<TreeNode>();
            results.add(null);
            return results;
        }
        else {
            return buildTrees(1, n);
        }

    }

    private List<TreeNode> buildTrees(int start, int n) {
        List<TreeNode> results = new ArrayList<TreeNode>();

        for (int i = start; i <= n; i++) {
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            List<TreeNode> rightTrees = buildTrees(i + 1, n);
            if (leftTrees.size() > 0 && rightTrees.size() > 0) {
                for (TreeNode lRoot : leftTrees) {
                    for (TreeNode rRoot : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = lRoot;
                        root.right = rRoot;
                        results.add(root);
                    }
                }
            }
            else if (leftTrees.size() > 0 && rightTrees.size() == 0) {
                for (TreeNode lRoot : leftTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    results.add(root);
                }
            }
            else if (leftTrees.size() == 0 && rightTrees.size() > 0) {
                for (TreeNode rRoot : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = rRoot;
                    results.add(root);
                }
            }
            else {
                results.add(new TreeNode(i));
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