import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Solution.Interval(3, 14));

        s.merge(intervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals != null && !intervals.isEmpty()) {
            Object[] arr = intervals.toArray();
            Arrays.sort(arr, new IntervalComparator());
            result.add(new Interval(((Interval) arr[0]).start, ((Interval) arr[0]).end));
            for (int i = 1; i < arr.length; i++) {
                Interval curr = ((Interval) arr[i]);
                Interval last = result.get(result.size() - 1);
                if (curr.start > last.start) {
                    if (curr.start <= last.end && curr.end > last.end) {
                        last.end = curr.end;
                    }
                    else if (curr.start > last.end) {
                        result.add(new Interval(curr.start, curr.end));
                    }
                }
                else {
                    if (curr.end > last.end) {
                        last.end = curr.end;
                    }
                }
            }
        }
        return result;
    }

    public class IntervalComparator implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {

            return ((Interval) o1).start - ((Interval) o2).start;
        }

    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
