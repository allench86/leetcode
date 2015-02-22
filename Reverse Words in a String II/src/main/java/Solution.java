public class Solution {
    public static void main(String[] args) {
        char[] a = "hi!".toCharArray();
        Solution s = new Solution();
        s.reverseWords(a);
        System.out.println(a);
    }

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

        l = 0;
        int i = l;
        while (i < s.length) {
            while (i < s.length && s[i] != ' ') {
                i++;
            }
            if (i < s.length && s[i] == ' ') {
                r = i - 1;
                while (l < r) {
                    char t = s[l];
                    s[l] = s[r];
                    s[r] = t;
                    l++;
                    r--;
                }
                l = i + 1;
                i = l;
            }
        }

        // for the last word
        r = i - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
