import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] inorder = { 3, 2, 1 };
        int[] postorder = { 3, 2, 1 };
        Solution s = new Solution();
        TreeNode root = s.buildTree(inorder, postorder);
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = buildATree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildATree(int[] inorder, int start, int end, int[] postorder, int postorderStart,
            int postorderRootIndex) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderRootIndex]);

        int rootInorderIndex = findRootIndex(inorder, start, end, root.val);
        if (rootInorderIndex != -1) {
            int leftStart = start;
            int leftEnd = rootInorderIndex - 1;
            int rightStart = rootInorderIndex + 1;
            int rightEnd = end;
            int leftRootPostorderIndex = postorderStart + (leftEnd - leftStart);
            int rightRootPostorderIndex = postorderRootIndex - 1;

            TreeNode left = buildATree(inorder, leftStart, leftEnd, postorder, postorderStart, leftRootPostorderIndex);
            TreeNode right = buildATree(inorder, rightStart, rightEnd, postorder, leftRootPostorderIndex + 1,
                    rightRootPostorderIndex);

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
