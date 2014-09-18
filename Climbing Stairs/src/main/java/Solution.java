public class Solution {
    public static void main(String[] args) {
        int n = 44;

        Solution s = new Solution();
        System.out.println(s.climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 4) {
            return n;
        }
        int a = 2, b = 3, c = 5;
        for (int i = 5; i <= n; i++) {
            a = c;
            c = a + b;
            b = a;
        }
        return c;
    }
}
