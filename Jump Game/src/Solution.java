//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int[] maxStepsLeft = new int[A.length];

        maxStepsLeft[0] = 0;
        for (int i = 1; i < A.length; i++) {
            maxStepsLeft[i] = Math.max(maxStepsLeft[i - 1], A[i - 1]) - 1;
            if (maxStepsLeft[i] < 0) {
                return false;
            }
        }

        return maxStepsLeft[maxStepsLeft.length - 1] >= 0;
    }
}
