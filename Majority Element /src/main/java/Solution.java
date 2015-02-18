public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
    }

    public int majorityElement(int[] num) {
        int current = 0;
        int counter = 0;
        if (num != null && num.length > 0) {
            for (int i = 0; i < num.length; i++) {
                if (counter == 0) {
                    current = num[i];
                    counter = 1;
                }
                else {
                    if (current == num[i]) {
                        counter++;
                    }
                    else {
                        counter--;
                    }
                }
            }
        }
        return current;
    }
}