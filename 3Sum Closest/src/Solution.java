import java.util.Arrays;

//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { -1, 2, 1, -4 };
        System.out.println(s.threeSumClosest(num, 1));
    }

    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        if (num.length == 3) {
            closestSum = num[0] + num[1] + num[2];
        }
        else {
            for (int i = 0; i < num.length - 2; i++) {
                int twoSumClosest = twoSumClosest(num, i + 1, target - num[i]);
                int sum = num[i] + twoSumClosest;
                int diff = Math.abs(target - sum);
                if (diff == 0) {
                    return sum;
                }
                else if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }

    private int twoSumClosest(int[] num, int start, int target) {
        int i = start;
        int j = num.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;

        while (i < j) {
            int sum = num[i] + num[j];
            int diff = Math.abs(target - sum);
            if (0 == diff) {
                return sum;
            }
            else if (sum < target) {
                i++;
                if (diff < minDiff) {
                    minDiff = diff;
                    minSum = sum;
                }
            }
            else {
                j--;
                if (diff < minDiff) {
                    minDiff = diff;
                    minSum = sum;
                }
            }
        }

        return minSum;
    }
}
