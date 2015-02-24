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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            int currentLevelNum = 1;
            int nextLevelNum = 0;
            q.offer(root);

            while (currentLevelNum != 0) {
                ArrayList<Integer> r = new ArrayList<Integer>();
                while (currentLevelNum != 0) {
                    TreeNode currentNode = q.poll();
                    r.add(currentNode.val);
                    currentLevelNum--;

                    if (currentNode.left != null) {
                        q.offer(currentNode.left);
                        nextLevelNum++;
                    }

                    if (currentNode.right != null) {
                        q.offer(currentNode.right);
                        nextLevelNum++;
                    }
                }
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                results.add(0, r);
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
