import java.util.LinkedList;
import java.util.Set;

public class Solution {
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
