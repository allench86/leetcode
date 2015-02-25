public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.isPalindrome(-2147447412));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int i = 0;
        while (temp > 0) {
            temp = temp / 10;
            i++;
        }
        if (i == 1) {
            return true;
        }

        temp = x;
        int temp2 = temp;
        int j = 1;
        while (j < i / 2 + 1) {
            int k = temp2 % 10;
            int l = (temp / (int) Math.pow(10, i - j)) % 10;
            if (k != l) {
                return false;
            }
            temp2 = temp2 / 10;
            j++;
        }

        return true;
    }
}