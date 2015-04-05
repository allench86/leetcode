public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) {
            return 0;
        }
        int m = n / 5;
        int t = 0;
        do {
            t += m;
            m /= 5;
        } while (m > 0);
        return t;
    }
}
