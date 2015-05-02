//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//  ["ABCE"],
//  ["SFCS"],
//  ["ADEE"]
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        int n = board.length;
        if (n == 0) {
            return false;
        }
        int m = board[0].length;
        if (m == 0) {
            return false;
        }

        boolean[] visited = new boolean[n * m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] == word.charAt(0)) {
                    visited[x * m + y] = true;
                    if (found(board, x, y, n, m, word, 0, visited)) {
                        return true;
                    }
                    visited[x * m + y] = false;
                }
            }
        }
        return false;
    }

    private boolean found(char[][] board, int x, int y, int n, int m, String word, int i, boolean[] visited) {
        if (i == word.length() - 1) {
            return true;
        }

        if (x - 1 >= 0 && visited[(x - 1) * m + y] == false) {
            if (board[x - 1][y] == word.charAt(i + 1)) {
                visited[(x - 1) * m + y] = true;
                if (found(board, x - 1, y, n, m, word, i + 1, visited)) {
                    return true;
                }
                visited[(x - 1) * m + y] = false;
            }
        }

        if (y - 1 >= 0 && visited[x * m + y - 1] == false) {
            if (board[x][y - 1] == word.charAt(i + 1)) {
                visited[x * m + y - 1] = true;
                if (found(board, x, y - 1, n, m, word, i + 1, visited)) {
                    return true;
                }
                visited[x * m + y - 1] = false;
            }
        }

        if (y + 1 < m && visited[x * m + y + 1] == false) {
            if (board[x][y + 1] == word.charAt(i + 1)) {
                visited[x * m + y + 1] = true;
                if (found(board, x, y + 1, n, m, word, i + 1, visited)) {
                    return true;
                }
                visited[x * m + y + 1] = false;
            }
        }

        if (x + 1 < n && visited[(x + 1) * m + y] == false) {
            if (board[x + 1][y] == word.charAt(i + 1)) {
                visited[(x + 1) * m + y] = true;
                if (found(board, x + 1, y, n, m, word, i + 1, visited)) {
                    return true;
                }
                visited[(x + 1) * m + y] = false;
            }
        }

        return false;
    }
}
