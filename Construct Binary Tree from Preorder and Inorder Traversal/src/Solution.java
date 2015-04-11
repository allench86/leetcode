//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 3 };
        int[] inorder = { 2, 3, 1 };
        Solution s = new Solution();
        TreeNode root = s.buildTree(preorder, inorder);
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr == null) {
                System.out.print("#,");
                continue;
            }
            System.out.print(curr.val + ",");
            stack.push(curr.right);
            stack.push(curr.left);

        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = buildATree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildATree(int[] inorder, int start, int end, int[] preorder, int preorderRootIndex,
            int preorderEnd) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);

        int rootInorderIndex = findRootIndex(inorder, start, end, root.val);
        if (rootInorderIndex != -1) {
            int leftStart = start;
            int leftEnd = rootInorderIndex - 1;
            int rightStart = rootInorderIndex + 1;
            int rightEnd = end;
            int leftRootPreorderIndex = preorderRootIndex + 1;
            int rightRootPreorderIndex = preorderRootIndex + (leftEnd - leftStart + 1) + 1;

            TreeNode left = buildATree(inorder, leftStart, leftEnd, preorder, leftRootPreorderIndex, preorderEnd);
            TreeNode right = buildATree(inorder, rightStart, rightEnd, preorder,
                    rightRootPreorderIndex, rightRootPreorderIndex - 1);

            root.left = left;
            root.right = right;
        }

        return root;
    }

    private int findRootIndex(int[] inorder, int start, int end, int rootValue) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootValue) {
                return i;
            }
        }
        return -1;
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
