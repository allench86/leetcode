//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        if (S.length() < T.length()) {
            return 0;
        }
        // d[i][j] is how many times string T(length i) occurs in string S(length j)
        int[][] d = new int[T.length() + 1][S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            d[0][i] = 1;
        }

        for (int i = 1; i < T.length(); i++) {
            d[i][0] = 0;
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (T.charAt(i - 1) != S.charAt(j - 1)) {
                    d[i][j] = d[i][j - 1];
                }
                else {
                    d[i][j] = d[i - 1][j - 1] + d[i][j - 1];
                }
            }
        }

        return d[T.length()][S.length()];
    }
}
