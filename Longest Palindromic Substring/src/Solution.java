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
        StringBuilder longestPalindrome = new StringBuilder();
        findLongestPalindrome(s, 0, longestPalindrome);
        return longestPalindrome.toString();
    }

    private void findLongestPalindrome(String s, int start, StringBuilder longestPalindrome) {
        if (start < s.length()) {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    if (longestPalindrome.length() < i - start + 1) {
                        longestPalindrome.delete(0, longestPalindrome.length());
                        longestPalindrome.append(s.substring(start, i + 1));
                    }
                    findLongestPalindrome(s, i + 1, longestPalindrome);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
