public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { -2, -8, -3, -2, 4, -10 };
        System.out.println(solution.maxSum(A));
    }

    public int maxSum(int[] A) {
        int max = A[0];
        int sum = 0;
        int tempStart = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (max < sum) {
                max = sum;
                if (tempStart > 0) {
                    start = tempStart + 1;
                }
                else {
                    start = tempStart;
                }
                end = i;
            }
            else if (sum < 0) {
                sum = 0;
                tempStart = i;
            }
        }

        System.out.println("Start:" + start + " End:" + end);

        return max;
    }
}
