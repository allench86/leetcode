public class Solution {
    public static void main(String[] args) {
        int[] n = { 3, 4, 1, 2 };

        Solution s = new Solution();
        System.out.println(s.findMin(n));
    }

    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int l = 0, h = num.length - 1, m = 0;
        int min = num[0];

        while (l < h - 1) {
            m = (l + h) / 2;
            if (num[l] < num[m]) {
                min = Math.min(num[l], min);
                l = m + 1;
            }
            else if (num[l] > num[m]) {
                min = Math.min(num[m], min);
                h = m - 1;
            }
            else {
                l++;
            }
        }

        min = Math.min(num[l], min);
        min = Math.min(num[h], min);
        return min;
    }

}
