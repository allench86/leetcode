public class Solution {
    public static void main(String[] args) {
        int x = 1000000003;

        Solution s = new Solution();
        System.out.println(s.reverse(x));
    }

    public int reverse(int x) {
        int result = 0;
        int tempX = x;
        while (tempX != 0) {
            int lastDigit = tempX % 10;
            result = result * 10 + lastDigit;
            if (x > 0 && result < 0 || (x < 0 && result > 0)) {
                result = x;
                break;
            }
            tempX /= 10;
        }

        return result;
    }

}
