public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                markY(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                markY(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                markY(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                markY(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markY(char[][] board, int x, int y) {
        board[x][y] = 'Y';

        if (x - 1 > 0) {
            if (board[x - 1][y] == 'O') {
                markY(board, x - 1, y);
            }
        }
        if (y - 1 > 0) {
            if (board[x][y - 1] == 'O') {
                markY(board, x, y - 1);
            }
        }
        if (x + 1 < board.length) {
            if (board[x + 1][y] == 'O') {
                markY(board, x + 1, y);
            }
        }
        if (board.length > 0 && y + 1 < board[0].length) {
            if (board[x][y + 1] == 'O') {
                markY(board, x, y + 1);
            }
        }
    }
}