public class Solution {
    public static void main(String[] args) {
        int[] n = { 4, 5, 6, 7, 1, 2, 3 };

        Solution s = new Solution();
        System.out.println(s.findMin(n));
    }

    public int findMin(int[] num) {
        int min = 0;
        if (num != null && num.length > 0) {
            int l = 0, h = num.length - 1;
            min = num[0];
            while (l < h - 1) {
                int mid = (l + h) / 2;
                if (num[l] < num[mid]) {
                    min = Math.min(min, num[l]);
                    l = mid + 1;
                }
                else if (num[l] > num[mid]) {
                    min = Math.min(min, num[mid]);
                    h = mid - 1;
                }
                else {
                    l++;
                }
            }

            min = Math.min(min, num[l]);
            min = Math.min(min, num[h]);
        }

        return min;
    }
}
