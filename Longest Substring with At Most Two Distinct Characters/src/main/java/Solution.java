import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstringTwoDistinct("aa"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;

        int i = 0, j = 1;
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        char[] input = s.toCharArray();
        chars.put(input[i], 1);
        while (j < input.length) {
            if (input[j] == input[i]) {
                j++;
                chars.put(input[i], chars.get(input[i]) + 1);
            }
            else {
                chars.put(input[j], 1);
                break;
            }
        }

        if (j == input.length) {
            maxLength = j - i;
        }
        else {
            j++;
            maxLength = j - i;
        }

        while (j < input.length) {
            if (chars.containsKey(input[j])) {
                chars.put(input[j], chars.get(input[j]) + 1);
                j++;
                maxLength = Math.max(maxLength, j - i);
            }
            else {
                do {
                    int num = chars.get(input[i]) - 1;
                    if (num == 0) {
                        chars.remove(input[i]);
                        i++;
                        break;
                    }
                    else {
                        chars.put(input[i], num);
                        i++;
                    }
                } while (i < j);
                chars.put(input[j], 1);
                j++;
            }
        }

        return maxLength;
    }
}