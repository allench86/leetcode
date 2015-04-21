public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s != null) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int offset = c - 'A' + 1;
                result = result * 26 + offset;
            }
        }
        return result;
    }
}