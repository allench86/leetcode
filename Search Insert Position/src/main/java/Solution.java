public class Solution {
    public static void main(String[] args) {
        int[] A = { 1, 3, 5 };
        int target = 6;
        Solution s = new Solution();
        System.out.println(s.searchInsert(A, target));
    }

    public int searchInsert(int[] A, int target) {
        int i = 0;
        while (i < A.length) {
            if (target == A[i]) {
                break;
            }
            else if (target < A[i]) {
                break;
            }
            else {
                i++;
            }
        }

        return i;
    }
}
