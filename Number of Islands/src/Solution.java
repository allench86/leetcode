public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null) {
            return num;
        }

        int n = grid.length;
        if (n == 0) {
            return num;
        }

        int m = grid[0].length;
        if (m == 0) {
            return num;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    mark(grid, n, m, i, j);
                }
            }
        }

        return num;
    }

    private void mark(char[][] grid, int n, int m, int i, int j) {
        grid[i][j] = '2';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            mark(grid, n, m, i - 1, j);
        }
        if (i + 1 < n && grid[i + 1][j] == '1') {
            mark(grid, n, m, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            mark(grid, n, m, i, j - 1);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            mark(grid, n, m, i, j + 1);
        }
    }
}
