public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 2, 4, 0, 1 },
                { 2, 4, 1, 1 },
        };
        s.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;

        boolean isZeroInFirstRow = false;
        boolean isZeroInFirstColumn = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isZeroInFirstColumn = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isZeroInFirstRow = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isZeroInFirstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (isZeroInFirstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}