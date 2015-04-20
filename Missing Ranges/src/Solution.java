//Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
//
//For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> results = new ArrayList<String>();
        if (A == null || lower > upper) {
            return results;
        }

        int prev = lower - 1;
        for (int i = 0; i <= A.length; i++) {
            int current = i == A.length ? upper + 1 : A[i];
            if ((current - prev) >= 2) {
                results.add(getRange(prev + 1, current - 1));
            }
            prev = current;
        }

        return results;
    }

    private String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
}
