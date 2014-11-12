public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("====================");
        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int nextI = j;
                int nextJ = n - 1 - i;
                int temp = matrix[nextI][nextJ];

                matrix[nextI][nextJ] = matrix[i][j];
                matrix[i][j] = temp;

                nextI = n - 1 - i;
                nextJ = n - 1 - j;
                temp = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = matrix[i][j];
                matrix[i][j] = temp;

                nextI = n - 1 - j;
                nextJ = i;
                temp = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = matrix[i][j];

                matrix[i][j] = temp;
            }
        }
    }
}
