public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return buildBST(num, 0, num.length - 1);
    }

    private TreeNode buildBST(int[] num, int startIndex, int endIndex) {
        TreeNode root = null;
        int length = endIndex - startIndex + 1;

        if (length == 1) {
            root = new TreeNode(num[startIndex]);
        }
        else {
            int mid = startIndex + length / 2;
            root = new TreeNode(num[mid]);
            root.left = buildBST(num, startIndex, mid - 1);
            if (length > 2) {
                root.right = buildBST(num, mid + 1, endIndex);
            }
        }

        return root;
    }
}