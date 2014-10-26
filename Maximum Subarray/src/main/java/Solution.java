public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { -1 };
        System.out.println(solution.maxSubArray(A));
    }

    public int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }
}
