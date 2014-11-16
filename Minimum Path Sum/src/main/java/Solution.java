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

        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = grid[0][i] + sum[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(grid[i][j] + sum[i - 1][j], grid[i][j] + sum[i][j - 1]);
            }
        }

        return sum[m - 1][n - 1];
    }
}