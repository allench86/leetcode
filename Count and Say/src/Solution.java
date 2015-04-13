//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(20));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            char[] preChars = result.toString().toCharArray();
            result.delete(0, result.length());
            int j = 0;
            while (j < preChars.length) {
                char currentChar = preChars[j];
                int currentCharCount = 0;
                while (j < preChars.length && currentChar == preChars[j]) {
                    currentCharCount++;
                    j++;
                }
                result.append(currentCharCount + "" + currentChar);
            }
        }

        return result.toString();
    }
}
