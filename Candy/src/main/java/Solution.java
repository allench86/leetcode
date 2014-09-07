public class Solution {
    public static void main(String[] args) {
        int[] ratings = { 5, 3, 1 };

        Solution s = new Solution();
        System.out.println(s.candy(ratings));
    }

    public int candy(int[] ratings) {
        int min = 0;
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        for (int i = 0; i < candies.length; i++) {
            min += candies[i];
        }

        return min;
    }
}
