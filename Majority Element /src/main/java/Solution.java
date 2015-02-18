import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
    }

    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        if (num != null) {
            if (num.length == 1) {
                return num[0];
            }
            for (int i : num) {
                if (countMap.containsKey(i)) {
                    int count = countMap.get(i);
                    count++;
                    if (count > num.length / 2) {
                        return i;
                    }
                    else {
                        countMap.put(i, count);
                    }
                }
                else {
                    countMap.put(i, 1);
                }
            }
        }

        return 0;
    }
}