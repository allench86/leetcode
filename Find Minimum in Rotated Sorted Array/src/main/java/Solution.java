public class Solution {
    public static void main(String[] args) {
        int[] n = { 4, 5, 6, 7, 1, 2, 3 };

        Solution s = new Solution();
        System.out.println(s.findMin(n));
    }

    public int findMin(int[] num) {
        int min = 0;
        if (num != null && num.length > 0) {
            int l = 0, h = num.length - 1, mid = (l + h) / 2;
            while (l < h) {
                if (num[mid] < num[l] && num[l] > num[h]) {
                    h = mid;
                }
                else if (num[mid] < num[l] && num[l] < num[h]) {
                    l = mid;
                }
                else if (num[mid] > num[l] && num[l] > num[h]) {
                    l = mid;
                }
                else if (num[mid] > num[l] && num[l] < num[h]) {
                    h = mid;
                }
                else if (num[mid] == num[l] && num[l] > num[h]) {
                    l = h;
                }
                else if (num[mid] == num[l] && num[l] < num[h]) {
                    h = l;
                }
                mid = (l + h) / 2;
            }
            min = num[l];
        }

        return min;
    }
}
