public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        int num = 1;
        int i = 0;
        while (i < Integer.SIZE - 1) {
            num <<= 1;
            i++;
        }
        int result = s.reverseBits(num);
        System.out.println();
        s.printNum(num);
        s.printNum(result);
    }

    private void printNum(int n) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        while (i < Integer.SIZE) {
            int currentBit = n & 0x0001;
            s.insert(0, currentBit);
            n >>= 1;
            i++;
        }
        System.out.println(s.toString());
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int t = 1;
        int i = 0;
        while (i < Integer.SIZE - 1) {
            t <<= 1;
            i++;
        }
        int currentBit = 0;
        while (n != 0) {
            currentBit = n & 0x0001;
            n >>>= 1;
            if (currentBit == 1) {
                result |= t;
            }
            t >>>= 1;
        }
        return result;
    }
}