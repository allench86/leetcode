public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(132));
    }

    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        if (n > 0) {
            while (n != 0) {
                int c = n % 26;
                if (c != 0) {
                    s.insert(0, new Character((char) ('A' + (c - 1))));
                    n = n / 26;
                }
                else {
                    s.insert(0, 'Z');
                    n = n / 26 - 1;
                }
            }
        }
        return s.toString();
    }
}
