public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(Integer.MAX_VALUE));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        int t = n;
        while (t != 0) {
            num += t & 0x0001;
            t = t >>> 1;
        }
        return num;
    }
}