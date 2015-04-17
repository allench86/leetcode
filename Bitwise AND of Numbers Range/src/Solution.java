public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int m = Integer.MAX_VALUE;
        int n = Integer.MAX_VALUE;
        System.out.println(s.rangeBitwiseAnd(m, n));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return m;
        }

        int fact = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            fact <<= 1;
        }

        return m * fact;
    }
}