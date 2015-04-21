import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String myString = "aba";
        List<List<String>> results = s.partition(myString);

        for (List<String> result : results) {
            for (String substring : result) {
                System.out.println(substring);
            }
            System.out.println("===");
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> substrings = new ArrayList<String>();
        char[] chars = s.toCharArray();
        findPalindrome(results, substrings, 0, chars.length - 1, chars, s);
        return results;
    }

    private void findPalindrome(List<List<String>> results, List<String> substrings, int start, int end, char[] chars,
            String s) {
        if (start == end) {
            results.add(new ArrayList<String>(substrings));
            return;
        }
        int length = end - start + 1;
        for (int i = 1; i <= length; i++) {
            if (isPalindrome(chars, start, start + i)) {
                substrings.add(s.substring(start, start + i));
                findPalindrome(results, substrings, i, end, chars, s);
                substrings.remove(substrings.size() - 1);
            }
        }

    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end && end < chars.length) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
