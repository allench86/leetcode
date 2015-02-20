import java.util.ArrayList;
import java.util.List;

public class Solution {
    int i = 0;

    public static void main(String[] args) {

        Solution s = new Solution();
        List<String> results = s.generateParenthesis(3);
        for (String ss : results) {
            System.out.println(ss);
        }
        System.out.println(s.i);
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        addParenthensis(results, "", '(', 1, 0, n);
        return results;
    }

    public void addParenthensis(List<String> results, String existingString, char next, int l, int r, int n) {
        if (l >= r) {
            existingString += next;
            if (existingString.length() == n * 2) {
                results.add(existingString);
                return;
            }
            if (n > l) {
                addParenthensis(results, existingString, '(', l + 1, r, n);
            }
            if (n > r && l > r) {
                addParenthensis(results, existingString, ')', l, r + 1, n);
            }
        }
    }
}