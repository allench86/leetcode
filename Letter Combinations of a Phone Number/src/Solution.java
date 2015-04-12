//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        if (digits != null && digits.length() > 0) {
            char[][] map = new char[10][];
            map[0] = " ".toCharArray();
            map[1] = "".toCharArray();
            map[2] = "abc".toCharArray();
            map[3] = "def".toCharArray();
            map[4] = "ghi".toCharArray();
            map[5] = "jkl".toCharArray();
            map[6] = "mno".toCharArray();
            map[7] = "pqrs".toCharArray();
            map[8] = "tuv".toCharArray();
            map[9] = "wxyz".toCharArray();
            results.add("");
            for (int i = 0; i < digits.length(); i++) {
                int digit = digits.charAt(i) - '0';
                if (digit == 1) {
                    continue;
                }

                char[] charMap = map[digit];
                int size = results.size();
                while (size > 0) {
                    String s = results.remove(size - 1);
                    for (char c : charMap) {
                        results.add(s + c);
                    }
                    size--;
                }
            }

        }
        return results;
    }
}
