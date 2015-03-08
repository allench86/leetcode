import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] n = { 1, 3, 2 };
        List<List<Integer>> r = s.subsets(n);
        for (List<Integer> a : r) {
            for (Integer i : a) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> subsets(int[] S) {
        if (S == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        if (S.length == 0) {
            return results;
        }
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int size = results.size();
            for (int j = 0; j < size; j++) {
                List<Integer> element = new ArrayList<Integer>(results.get(j));
                element.add(S[i]);
                results.add(element);
            }
        }

        return results;
    }
}