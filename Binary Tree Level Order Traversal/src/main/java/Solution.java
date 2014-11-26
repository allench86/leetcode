import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // n3.left = n4;
        // n3.right = n5;
        // n4.left = n6;

        List<List<Integer>> results = s.levelOrder(n1);
        for (List<Integer> element : results) {
            for (Integer i : element) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

            currentLevel.add(root);
            while (!currentLevel.isEmpty()) {
                Queue<TreeNode> temp = currentLevel;
                List<Integer> valuesInCurrentLevel = new ArrayList<Integer>();
                while (!currentLevel.isEmpty()) {
                    TreeNode currentNode = currentLevel.poll();
                    valuesInCurrentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        nextLevel.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        nextLevel.add(currentNode.right);
                    }
                }
                results.add(valuesInCurrentLevel);
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        return results;
    }

    /**
     * Definition for binary tree
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
