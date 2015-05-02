public class Solution {
    public void rotate(int[] nums, int k) {
        if (k > 0) {
            int t = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, t - 1);
            reverse(nums, t, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
