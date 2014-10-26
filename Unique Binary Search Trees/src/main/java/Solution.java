//trees[n] = trees[n-1]*trees[0]
//         + trees[n-2]*trees[1]
//         + ...
//         + trees[1]*trees[n-2]
//         + trees[0]*trees[n-1]
public class Solution {
    public static void main(String[] args) {
        int n = 0;
        Solution s = new Solution();

        System.out.println(s.numTrees(n));
    }

    public int numTrees(int n) {
        int result = 0;
        if (n >= 0) {
            int[] trees = new int[n + 1];
            trees[0] = 1;
            for (int i = 1; i < trees.length; i++) {
                for (int j = 0; j < i; j++) {
                    trees[i] += trees[j] * trees[i - j - 1];
                }
            }
            result = trees[n];
        }
        return result;
    }
}
