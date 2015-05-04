public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String t = "aba";
        System.out.println(s.longestPalindrome(t));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        boolean[][] flags = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                flags[i][j] = false;
            }
        }

        int longestPalindromeStart = 0;
        int longestPalindromeEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            flags[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                flags[i][i - 1] = true;
                longestPalindromeStart = i - 1;
                longestPalindromeEnd = i;
            }
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (flags[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    flags[i][j] = true;
                    if (j - i > longestPalindromeEnd - longestPalindromeStart) {
                        longestPalindromeStart = i;
                        longestPalindromeEnd = j;
                    }
                }
            }
        }

        return s.substring(longestPalindromeStart, longestPalindromeEnd + 1);
    }
}
