import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> results = new ArrayList<String[]>();
        findAnswers(n, 0, new int[n], results);
        return results;
    }

    private void findAnswers(int n, int row, int[] colInRow, List<String[]> results) {
        if (row == n) {
            String[] result = new String[n];
            for (int i = 0; i < colInRow.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == colInRow[i]) {
                        s.append('Q');
                    }
                    else {
                        s.append('.');
                    }
                }
                result[i] = s.toString();
            }
            results.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            colInRow[row] = i;
            if (check(row, colInRow)) {
                findAnswers(n, row + 1, colInRow, results);
            }
        }
    }

    private boolean check(int row, int[] colInRow) {
        for (int i = 0; i < row; i++) {
            if (colInRow[i] == colInRow[row] || Math.abs(colInRow[i] - colInRow[row]) == row - i) {
                // Math.abs(colInRow[i] - colInRow[row]) == row - i 检查斜线上是否满足条件
                return false;
            }
        }
        return true;
    }
}
