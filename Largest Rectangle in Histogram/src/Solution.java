import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxV = 0;
        if (height != null && height.length > 0) {
            Stack<Integer> stack = new Stack<Integer>();
            int i = 0;
            while (i <= height.length) {
                int h = height[i];
                if (i == height.length) {
                    h = 0;
                }
                if (stack.isEmpty() || height[stack.peek()] <= h) {
                    stack.push(i++);
                }
                else {
                    int t = stack.pop();
                    maxV = Math.max(maxV, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                }
            }
        }
        return maxV;
    }
}
