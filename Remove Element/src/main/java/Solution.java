public class Solution {
    public static void main(String[] args) {
        int[] A = { 1, 3, 2 };
        int elem = 2;

        Solution s = new Solution();
        System.out.println(s.removeElement(A, elem));
    }

    public int removeElement(int[] A, int elem) {
        int newLength = 0;
        if (A == null || A.length == 0) {
            return newLength;
        }

        int j = A.length - 1;
        while (newLength <= j) {
            if (A[newLength] != elem) {
                newLength++;
            }
            else {
                while (j >= 0 && A[j] == elem) {
                    j--;
                }

                if (j > newLength) {
                    A[newLength] = A[j];
                    j--;
                }
            }
        }
        return newLength;
    }
}
