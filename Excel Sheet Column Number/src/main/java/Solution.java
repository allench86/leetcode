public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s != null) {
            char[] chars = s.toCharArray();
            int i = chars.length - 1;
            for (char c : chars) {
                int offset = c - 'A' + 1;
                result += offset * Math.pow(26, i);
                i--;
            }
        }
        return result;
    }
}