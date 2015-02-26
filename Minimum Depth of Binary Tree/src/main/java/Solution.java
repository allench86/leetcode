import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        // n4.left = n6;

        Solution s = new Solution();
        System.out.println(s.minDepth(n1));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        TreeNode currentNode = null;
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        do {
            nextLevelNum = 0;
            while (currentLevelNum > 0) {
                currentNode = q.poll();
                currentLevelNum--;
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
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
            depth++;
        } while (currentLevelNum > 0);

        return depth;
    }
}