public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 2, 4, 6, 1, 2, 4, 5 };
        System.out.println(s.rob(num));
    }

    public int rob(int[] num) {
        if (num == null || num.length == 0)
        {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        if (num.length == 2) {
            return Math.max(num[0], num[1]);
        }

        int[] temp = new int[num.length];
        temp[0] = num[0];
        temp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < num.length; i++) {
            temp[i] = Math.max(temp[i - 1], temp[i - 2] + num[i]);
        }
        return temp[temp.length - 1];
    }
}