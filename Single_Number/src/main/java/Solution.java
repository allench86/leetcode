public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 1, 5, 7, 3, 5, 7 };
        System.out.println(solution.singleNumber(A));
    }

    public int singleNumber(int[] A) {
        int result = -1;

        if (A != null && A.length > 0) {
            int i = 0;
            result = A[i];
            i++;
            while (i < A.length) {
                result ^= A[i];
                i++;
            }
        }
        return result;
    }
}
