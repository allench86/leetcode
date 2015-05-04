public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String t = "a";
        System.out.println(s.longestPalindrome(t));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = findPalindrome(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            tmp = findPalindrome(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    private String findPalindrome(String s, int centerIndex1, int centerIndex2) {
        while (centerIndex1 >= 0 && centerIndex2 < s.length() && s.charAt(centerIndex1) == s.charAt(centerIndex2)) {
            centerIndex1--;
            centerIndex2++;
        }

        return s.substring(centerIndex1 + 1, centerIndex2);

    }
}
