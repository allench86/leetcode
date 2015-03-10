public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] paths = new int[n];
        for (int i = 1; i < n; i++) {
            paths[i] = 0;
        }
        if (obstacleGrid[0][0] == 0) {
            paths[0] = 1;
        }
        else {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[j] = 0;
                }
                else {
                    if (j > 0) {
                        paths[j] = paths[j - 1] + paths[j];
                    }
                }
            }
        }

        return paths[n - 1];
    }
}
