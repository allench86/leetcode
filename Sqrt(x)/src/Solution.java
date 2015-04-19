public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int i = 0;
        int j = x / 2 + 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (mid != 0) {
                if (mid * mid / mid == mid) {
                    int sq = mid * mid;
                    if (sq == x) {
                        return mid;
                    }
                    else if (sq < x) {
                        i = mid + 1;
                    }
                    else {
                        j = mid - 1;
                    }
                }
                else {
                    j = mid - 1;
                }
            }
        }

        return (i + j) / 2;
    }
}
