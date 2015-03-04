public class Solution {
    public static void main(String[] args) {
        int[] numbers = { 0, 0, 3, 4 };
        Solution s = new Solution();
    }

    public int trap(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];
        int totalTrap = 0;
        int currentTrap = 0;
        int max = A[0];
        maxL[0] = 0;
        for (int i = 1; i < A.length; i++) {
            maxL[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }

        maxR[A.length - 1] = 0;
        max = A[A.length - 1];

        for (int i = A.length - 2; i > 0; i--) {
            maxR[i] = max;
            currentTrap = Math.min(maxL[i], maxR[i]) - A[i];
            if (currentTrap > 0) {
                totalTrap += currentTrap;
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return totalTrap;
    }
}