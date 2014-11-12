public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 2, 3, 4, 5 };
        System.out.println(solution.maxArea(A));
    }

    public int maxArea(int[] height) {
        int max = 0;
        if (height.length <= 1) {
            return max;
        }
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }

            if (height[left] < height[right]) {
                int tempLeft = left + 1;
                while (tempLeft < height.length && height[tempLeft] < height[left]) {
                    tempLeft++;
                }
                if (tempLeft < height.length) {
                    left = tempLeft;
                }
            }
            else {
                int tempRight = right - 1;
                while (tempRight > left && height[tempRight] < height[right]) {
                    tempRight--;
                }
                right = tempRight;
            }

        }

        return max;
    }
}
