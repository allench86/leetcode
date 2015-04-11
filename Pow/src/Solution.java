public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        double x = 3;
        int n = -2;
        System.out.println(s.pow(x, n));
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1.0 / power(x, -n);
        }
        else {
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x;
        }
        double t = power(x, n / 2);
        if (n % 2 == 0) {
            return t * t;
        }
        else {
            return t * t * x;
        }
    }
}
