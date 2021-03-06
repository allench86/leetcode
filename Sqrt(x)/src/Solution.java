public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double last = 0;
        double next = 1;
        while (next != last) {
            last = next;
            next = (next + x / next) / 2;
        }
        return (int) next;
    }
}
