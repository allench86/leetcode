import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("aa"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        int max = 1;
        int i = 0;
        int j = 1;
        chars[s.charAt(i)] = i;
        while (j < s.length()) {
            if (chars[s.charAt(j)] >= i) {
                // found a char that occurred once
                i = chars[s.charAt(j)] + 1;
            }
            max = Math.max(max, j - i + 1);
            chars[s.charAt(j)] = j;
            j++;
        }
        return max;
    }
}
