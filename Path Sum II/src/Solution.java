//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }

        TreeNode dummy = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        stack.push(root);
        int currSum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == dummy) {
                if (!result.isEmpty()) {
                    currSum -= result.remove(result.size() - 1);
                }
            }
            else {
                currSum += curr.val;
                result.add(curr.val);
                if (curr.left != null || curr.right != null) {
                    stack.push(dummy);
                }

                if (curr.right != null) {
                    stack.push(curr.right);
                }

                if (curr.left != null) {
                    stack.push(curr.left);
                }

                if (curr.left == null && curr.right == null) {
                    if (currSum == sum) {
                        results.add(new ArrayList<Integer>(result));
                    }

                    currSum -= result.remove(result.size() - 1);
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
