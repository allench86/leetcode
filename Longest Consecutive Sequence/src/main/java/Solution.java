import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] num = { 2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645 };
        System.out.println(s.longestConsecutive(num));
    }

    public int longestConsecutive(int[] num) {
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : num) {
            if (map.containsKey(i)) {
                continue;
            }
            int left = i, right = i;
            map.put(left, right);
            if (map.containsKey(i - 1)) {
                left = map.get(i - 1);
            }
            if (left != i || right != i) {
                map.put(left, right);
                map.put(right, left);
            }
            map.put(left, right);
            map.put(right, left);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}