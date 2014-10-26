import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Solution {
    public static void main(String[] args) {
        int n = 0;
        Solution s = new Solution();

        // System.out.println(s.maxProfit(n));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        while (i < prices.length) {
            PriceAndIndex lowestAndIndex = findLowest(prices, i);
            PriceAndIndex highestAndIndex = findHighest(prices, lowestAndIndex.index);
            i = highestAndIndex.index + 1;
            maxProfit += highestAndIndex.price - lowestAndIndex.price;
            System.out.println("lowestAndIndex.price=" + lowestAndIndex.price + " lowestAndIndex.index="
                    + lowestAndIndex.index + " highestAndIndex.price=" + highestAndIndex.price
                    + " highestAndIndex.index="
                    + highestAndIndex.index + " maxProfit=" + maxProfit);
            if (i == prices.length || highestAndIndex.index == lowestAndIndex.index) {
                break;
            }
        }
        return maxProfit;
    }

    public PriceAndIndex findLowest(int[] prices, int startIndex) {
        int lowest = prices[startIndex];
        PriceAndIndex lowestAndIndex = new PriceAndIndex(lowest, startIndex);
        for (int i = startIndex + 1; i < prices.length; i++) {
            if (lowest > prices[i]) {
                lowest = prices[i];
                lowestAndIndex.setPrice(lowest);
                lowestAndIndex.setIndex(i);
            }
            else {
                break;
            }
        }
        return lowestAndIndex;
    }

    public PriceAndIndex findHighest(int[] prices, int startIndex) {
        int highest = prices[startIndex];
        PriceAndIndex highestAndIndex = new PriceAndIndex(highest, startIndex);
        for (int i = startIndex + 1; i < prices.length; i++) {
            if (highest <= prices[i]) {
                highest = prices[i];
                highestAndIndex.setPrice(highest);
                highestAndIndex.setIndex(i);
            }
            else {
                break;
            }
        }
        return highestAndIndex;
    }

    public static class PriceAndIndex {
        private int price;
        private int index;

        public PriceAndIndex(int price, int index) {
            this.setPrice(price);
            this.setIndex(index);
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(price).append(index).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PriceAndIndex))
                return false;
            if (obj == this)
                return true;

            PriceAndIndex rhs = (PriceAndIndex) obj;
            return new EqualsBuilder().
                    append(price, rhs.price).
                    append(index, rhs.index).
                    isEquals();
        }
    }
}
