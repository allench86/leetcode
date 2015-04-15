//Given two strings S and T, determine if they are both one edit distance apart.
public class Solution {
    public static void main(String[] args) {
        String s = "ab";
        String t = "Ab";
        Solution solution = new Solution();
        System.out.println(solution.isOneEditDistance(s, t));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int sLength = s.length();
        int tLength = t.length();

        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        else {
            if (sLength > tLength) {
                String temp = s;
                s = t;
                t = temp;
                sLength = s.length();
                tLength = t.length();
            }

            int diff = tLength - sLength;

            int i = 0;
            while (i < sLength && s.charAt(i) == t.charAt(i)) {
                i++;
            }

            if (i == sLength) {
                return diff > 0;
            }

            if (diff == 0) {
                i++;
            }

            while (i < sLength && s.charAt(i) == t.charAt(i + diff)) {
                i++;
            }

            return i == sLength;
        }
    }
}
