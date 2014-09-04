public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 1, 1, 5, 5, 7, 3, 5, 7, 7 };
        System.out.println(solution.singleNumber(A));
    }

    public int singleNumber(int[] A) {
        int result = 0;
        if (A != null && A.length > 0) {
            int shift = 0;
            while (shift < 32) {
                int lastDigitSum = 0;
                for (int i = 0; i < A.length; i++) {
                    int temp = A[i];
                    temp = temp >>> shift;
                    lastDigitSum += temp % 2;
                }
                int currentDigitInResult = lastDigitSum % 3;
                currentDigitInResult = currentDigitInResult << shift;
                result |= currentDigitInResult;
                shift++;
            }
        }
        return result;
    }
}
