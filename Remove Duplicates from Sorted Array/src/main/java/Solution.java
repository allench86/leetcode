public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5 };
        int newLength = solution.removeDuplicates(A);
        System.out.println(newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(A[i] + ", ");
        }
    }

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int i = 1;
        int j = 0, k = 1;
        while (k < A.length) {
            if (A[j] != A[k]) {
                A[i] = A[k];
                i++;
                j++;
                k++;
            }
            else {
                while (k < A.length && A[j] == A[k]) {
                    k++;
                }
                if (k < A.length) {
                    A[i] = A[k];
                    i++;
                    j = k;
                    k++;
                }
            }
        }

        return i;
    }
}
