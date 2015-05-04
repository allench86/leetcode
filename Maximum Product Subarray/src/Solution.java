public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxp = nums[0];
        int minp = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempmaxp = maxp;
            int tempminp = minp;
            maxp = Math.max(Math.max(tempmaxp * nums[i], tempminp * nums[i]), nums[i]);
            minp = Math.min(Math.min(tempminp * nums[i], tempmaxp * nums[i]), nums[i]);
            result = Math.max(maxp, result);
        }
        return result;
    }
}
