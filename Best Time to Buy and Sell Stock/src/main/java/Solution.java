public class Solution {
    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        Solution s = new Solution();

        System.out.println(s.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 0) {
            int maxIndex = prices.length - 1, minIndex = 0;
            int max = prices[maxIndex];

            do {
                minIndex = maxIndex - 1;
                int min = prices[minIndex > 0 ? minIndex : 0];
                while (minIndex > 0 && prices[minIndex] > prices[maxIndex]) {
                    minIndex--;
                    maxIndex--;
                }

                if (max > prices[maxIndex] && maxIndex != prices.length - 1) {
                    maxIndex = minIndex - 1;
                    continue;
                }
                max = prices[maxIndex];

                while (minIndex >= 0) {
                    while (minIndex - 1 >= 0 && prices[minIndex] > prices[minIndex - 1]) {
                        minIndex--;
                    }

                    if (minIndex >= 0 && maxIndex >= 0 && min >= prices[minIndex]) {
                        maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);
                        min = prices[minIndex];
                    }
                    minIndex--;
                }
                maxIndex = maxIndex - 1;
            } while (maxIndex > 0);
        }

        return maxProfit;
    }
}
