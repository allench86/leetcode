import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] input = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa" };
        // String s = "aaaaaaab";
        // String[] input = { "a", "aa", "aaa" };
        // String s = "catsanddog";
        // String[] input = { "cat", "cats", "and", "sand", "dogs" };
        Set<String> dict = buildDict(input);

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, dict));
    }

    public static Set<String> buildDict(String[] input) {
        Set<String> dict = new HashSet<String>();
        for (String s : input) {
            dict.add(s);
        }
        return dict;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return false;
        }
        LinkedList<Integer> starts = new LinkedList<Integer>();
        starts.add(0);

        for (int end = 1; end <= s.length(); end++) {
            boolean found = false;
            for (Integer start : starts) {
                if (dict.contains(s.subSequence(start, end))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                starts.add(0, end);
            }
        }

        return starts.get(0) == s.length();
    }
}
