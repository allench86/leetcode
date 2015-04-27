public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { -1 };
        System.out.println(solution.maxSubArray(A));
    }

    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
