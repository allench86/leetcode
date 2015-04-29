public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {
                { 1, 2, 3, 4 },
                { 2, 4, 1, 1 }
        };
        System.out.println(s.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        int[] sum = new int[n];
        sum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[i] = grid[0][i] + sum[i - 1];
        }

        for (int i = 1; i < m; i++) {
            sum[0] = sum[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                sum[j] = Math.min(sum[j] + grid[i][j], sum[j - 1] + grid[i][j]);
            }
        }

        return sum[n - 1];
    }
}