public class Solution {
    public static void main(String[] args) {
        int n = 0;
        Solution s = new Solution();

        // System.out.println(s.maxProfit(n));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 1;
        while (i < prices.length) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
            i++;
        }
        return maxProfit;
    }

}
