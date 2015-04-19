public class Solution {
    int[] bucket = new int[26];

    public Solution() {
        for (int i = 0; i < 26; i++) {
            bucket[i] = 0;
        }
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        for (int i = 0; i < s1c.length; i++) {
            bucket[s1c[i] - 'a'] += 1;
            bucket[s2c[i] - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 1) {
                return false;
            }
        }

        for (int i = 1; i < s1c.length; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }

            s21 = s2.substring(0, s1c.length - i);
            s22 = s2.substring(s1c.length - i);
            if (isScramble(s11, s22) && isScramble(s12, s21)) {
                return true;
            }
        }
        return false;
    }
}
