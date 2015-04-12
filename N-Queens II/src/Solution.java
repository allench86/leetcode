public class Solution {
    private int total = 0;

    public int totalNQueens(int n) {
        findAnswer(n, 0, new int[n]);
        return total;
    }

    private void findAnswer(int n, int row, int[] colInRow) {
        if (row == n) {
            total++;
            return;
        }

        for (int i = 0; i < n; i++) {
            colInRow[row] = i;
            if (check(row, colInRow)) {
                findAnswer(n, row + 1, colInRow);
            }
        }
    }

    private boolean check(int row, int[] colInRow) {
        for (int i = 0; i < row; i++) {
            if (colInRow[row] == colInRow[i] || Math.abs(colInRow[i] - colInRow[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
