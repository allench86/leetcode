//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] maxProfitFromLeft = new int[prices.length];
        int[] maxProfitFromRight = new int[prices.length];
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            }
            int temp = prices[i] - minValue;
            if (temp > maxProfit) {
                maxProfit = temp;
            }
            maxProfitFromLeft[i] = maxProfit;
        }

        maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (maxValue < prices[i]) {
                maxValue = prices[i];
            }
            int temp = maxValue - prices[i];
            if (temp > maxProfit) {
                maxProfit = temp;
            }
            maxProfitFromRight[i] = maxProfit;
        }

        maxProfit = Integer.MIN_VALUE;
        for (int j = 0; j < prices.length - 1; j++) {
            maxProfit = Math.max(maxProfit, maxProfitFromLeft[j] + maxProfitFromRight[j + 1]);
        }

        // when there are only two elements in prices
        if (maxProfit < maxProfitFromRight[0]) {
            maxProfit = maxProfitFromRight[0];
        }

        return maxProfit;
    }
}
