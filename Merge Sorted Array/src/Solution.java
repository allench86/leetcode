public class Solution {
    public static void main(String[] args) {
        int[] A = new int[2];
        A[0] = 1;
        int[] B = { 2 };

        Solution s = new Solution();
        s.merge(A, 1, B, 1);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i] + ",");
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, p = m + n - 1;
        while (i >= 0 && j >= 0) {
            while (j >= 0 && A[i] < B[j]) {
                A[p] = B[j];
                p--;
                j--;
            }
            while (i >= 0 && j >= 0 && A[i] >= B[j]) {
                A[p] = A[i];
                p--;
                i--;
            }
        }

        while (j >= 0) {
            A[p] = B[j];
            p--;
            j--;
        }
    }
}
