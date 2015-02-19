public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 1 };
        System.out.println(s.findPeakElement(num));
    }

    public int findPeakElement(int[] num) {
        if (num.length == 1) {
            return 0;
        }
        return findPeakElementInRange(num, 0, num.length - 1);
    }

    public int findPeakElementInRange(int[] num, int l, int h) {
        int index = -1;
        int m = (h + l) / 2;
        int left = m - 1 >= 0 ? num[m - 1] : Integer.MIN_VALUE;
        int right = m + 1 < num.length ? num[m + 1] : Integer.MIN_VALUE;
        if (left < num[m] && right < num[m]) {
            index = m;
            return index;
        }
        else {
            if (l != m) {
                index = findPeakElementInRange(num, l, m);
                if (index != -1) {
                    return index;
                }
            }
            if (h != m) {
                index = findPeakElementInRange(num, m + 1, h);
                if (index != -1) {
                    return index;
                }
            }
        }
        return index;
    }
}