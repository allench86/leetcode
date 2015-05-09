import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth = 1;
            List<Integer> level = new ArrayList<Integer>();
            Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
            currentLevel.add(root);
            int currentLevelNum = 1;
            while (currentLevelNum > 0) {
                TreeNode curr = currentLevel.poll();

                if (curr.left != null) {
                    currentLevel.offer(curr.left);
                }

                if (curr.right != null) {
                    currentLevel.offer(curr.right);
                }

                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                level.add(curr.val);
                currentLevelNum--;
                if (currentLevelNum == 0) {
                    currentLevelNum = currentLevel.size();
                    depth++;
                }
            }
        }

        return depth;
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
