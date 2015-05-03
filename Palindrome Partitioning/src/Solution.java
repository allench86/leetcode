import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String myString = "aab";
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
        findPalindrome(results, substrings, 0, s);
        return results;
    }

    private void findPalindrome(List<List<String>> results, List<String> substrings, int start,
            String s) {
        if (start == s.length()) {
            results.add(new ArrayList<String>(substrings));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                substrings.add(s.substring(start, i + 1));
                findPalindrome(results, substrings, i + 1, s);
                substrings.remove(substrings.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
