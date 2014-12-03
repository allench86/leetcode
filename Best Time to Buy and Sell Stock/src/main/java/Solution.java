public class Solution {
    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 8, 0, 3 };
        Solution s = new Solution();

        System.out.println(s.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 1) {
            maxProfit = prices[1] - prices[0];
            int minPrice = prices[0];

            for (int i = 2; i < prices.length; i++) {
                minPrice = Math.min(prices[i - 1], minPrice);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}
