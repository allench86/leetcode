//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            int currentLevel = 0;
            s1.push(root);
            TreeNode curr = null;
            ArrayList<Integer> result = new ArrayList<Integer>();
            while (!s1.isEmpty() || !s2.isEmpty()) {
                if (currentLevel % 2 == 0 && !s1.isEmpty()) {
                    curr = s1.pop();
                    result.add(curr.val);
                    if (curr.left != null) {
                        s2.push(curr.left);
                    }
                    if (curr.right != null) {
                        s2.push(curr.right);
                    }
                    if (s1.isEmpty()) {
                        currentLevel++;
                        results.add(result);
                        result = new ArrayList<Integer>();
                    }
                }
                else if (currentLevel % 2 != 0 && !s2.isEmpty()) {
                    curr = s2.pop();
                    result.add(curr.val);
                    if (curr.right != null) {
                        s1.push(curr.right);
                    }
                    if (curr.left != null) {
                        s1.push(curr.left);
                    }
                    if (s2.isEmpty()) {
                        currentLevel++;
                        results.add(result);
                        result = new ArrayList<Integer>();
                    }
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
