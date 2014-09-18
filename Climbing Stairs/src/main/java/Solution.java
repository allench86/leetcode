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
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
