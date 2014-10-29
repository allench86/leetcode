public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 0, 2, 1, 2, 0 };
        solution.sortColors(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
    }

    public void sortColors(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return;
        }
        int i = 0, j = 0, k = A.length - 1;

        while (i <= k) {
            if (A[i] == 0) {
                swap(A, i, j);
                i++;
                j++;
                continue;
            }
            if (A[i] == 2) {
                swap(A, i, k);
                k--;
                continue;
            }
            i++;
        }
    }

    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
