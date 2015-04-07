//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution {
    public static void main(String[] args) {
        String[] t = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
                "8........", "9........" };
        char[][] k = new char[t.length][];

        for (int i = 0; i < t.length; i++) {
            k[i] = t[i].toCharArray();
        }

        Solution s = new Solution();
        System.out.println(s.isValidSudoku(k));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int n = board.length;
        int m = board[0].length;

        int[] digits = new int[9];
        resetDigitsArray(digits);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (digits[board[i][j] - '1'] == 1) {
                        System.out.println("i=" + i + ",j=" + j);
                        return false;
                    }
                    else {
                        digits[board[i][j] - '1'] = 1;
                    }
                }
            }
            resetDigitsArray(digits);
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (digits[board[i][j] - '1'] == 1) {
                        System.out.println("1");
                        return false;
                    }
                    else {
                        digits[board[i][j] - '1'] = 1;
                    }
                }
            }
            resetDigitsArray(digits);
        }

        int horizotalGroupNum = m / 3;
        int virticalGroupNum = n / 3;
        for (int t = 0; t < horizotalGroupNum; t++) {
            for (int s = 0; s < virticalGroupNum; s++) {
                for (int i = s * 3; i < s * 3 + 3; i++) {
                    for (int j = t * 3; j < t * 3 + 3; j++) {
                        char c = board[i][j];
                        if (c != '.') {
                            if (digits[board[i][j] - '1'] == 1) {
                                System.out.println("1");
                                return false;
                            }
                            else {
                                digits[board[i][j] - '1'] = 1;
                            }
                        }
                    }
                }
                resetDigitsArray(digits);
            }
        }

        return true;
    }

    private void resetDigitsArray(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }
    }
}
