public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0, index = i; index < s.length(); j++, index = (2 * numRows - 2) * j + i) {
                result.append(s.charAt(index));
                if (i == 0 || i == numRows - 1) {
                    continue;
                }
                if (index + (numRows - i - 1) * 2 < s.length()) {
                    result.append(s.charAt(index + (numRows - i - 1) * 2));
                }
            }
        }

        return result.toString();
    }
}
