public class Solution {

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();

        boolean[][][] dp = new boolean[len][len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k <= len; k++) {
            for (int i = len - k; i >= 0; i--) {
                for (int j = len - k; j >= 0; j--) {
                    boolean canTransfer = false;
                    for (int m = 1; m < k && !canTransfer; m++) {
                        canTransfer = (dp[m - 1][i][j] && dp[k - m - 1][i + m][j + m])
                                || (dp[m - 1][i][j + k - m] && dp[k - m - 1][i + m][j]);
                    }
                    dp[k - 1][i][j] = canTransfer;
                }
            }
        }

        return dp[len - 1][0][0];
    }
}
