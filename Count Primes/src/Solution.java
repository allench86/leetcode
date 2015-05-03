import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countPrimes(3));
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] flags = new boolean[n + 1];
        Arrays.fill(flags, true);
        int count = n - 2;

        double root = Math.sqrt(n);
        for (int i = 2; i < root; i++) {
            if (flags[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    if (flags[j]) {
                        flags[j] = false;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}
