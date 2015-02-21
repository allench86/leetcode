public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int n = 4;
        int[][] matrix = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%3d ", matrix[i][j]));
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n >= 0 ? n : 0][n >= 0 ? n : 0];
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = i + 1;
            }

            int k = 0;
            int mirrorLine = n % 2 == 0 ? n / 2 : (n - 1) / 2;

            for (int i = 1; i < n; i++) {
                int x = n - k - 1;
                int y = 4 * (n - 1 - k * 2) - 1;
                int z = 4 * (n - (k + 1) * 2) - 1;
                for (int j = 0; j < n; j++) {
                    if (i <= mirrorLine) {
                        if (j < k) {
                            matrix[i][j] = matrix[i - 1][j] - 1;
                        }
                        else if (j < x) {
                            matrix[i][j] = matrix[i - 1][j] + y;
                        }
                        else {
                            matrix[i][j] = matrix[i - 1][j] + 1;
                        }
                    }
                    else {
                        if (j <= k) {
                            matrix[i][j] = matrix[i - 1][j] - 1;
                        }
                        else if (j < x) {
                            matrix[i][j] = matrix[i - 1][j] - z;
                        }
                        else {
                            matrix[i][j] = matrix[i - 1][j] + 1;
                        }
                    }
                }
                if (n % 2 != 0) {
                    if (i < mirrorLine) {
                        k++;
                    }
                    else if (i > mirrorLine) {
                        k--;
                    }
                }
                else {
                    if (i < mirrorLine) {
                        k++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return matrix;
    }
}