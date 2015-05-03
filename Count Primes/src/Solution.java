import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countPrimes(100));
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 1;
        }

        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= n; i++) {
            boolean isPrimes = true;
            int j = 0;
            while (j < primes.size()) {
                if (i % primes.get(j) == 0) {
                    isPrimes = false;
                    break;
                }
                j++;
            }
            if (isPrimes) {
                primes.add(i);
            }
        }
        return primes.size();
    }
}
