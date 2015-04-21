public class Solution {
    public static void main(String[] args) {
        int[] A = { 3 };
        int target = 3;
        Solution s = new Solution();
        System.out.println(s.searchInsert(A, target));
    }

    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int r = 0;
        int l = A.length - 1;
        while (r <= l) {
            int mid = (r + l) / 2;
            if (A[mid] >= target) {
                l = mid - 1;
            }
            else {
                r = mid + 1;
            }
        }

        return r;
    }
}
