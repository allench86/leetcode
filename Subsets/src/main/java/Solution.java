import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] n = { 1 };
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
        Arrays.sort(S);
        return helper(S, S.length - 1);

    }

    private List<List<Integer>> helper(int[] num, int index) {
        if (index == -1) {
            List<List<Integer>> results = new ArrayList<List<Integer>>();
            results.add(new ArrayList<Integer>());
            return results;
        }

        List<List<Integer>> preResults = helper(num, index - 1);
        int size = preResults.size();
        for (int i = 0; i < size; i++) {
            List<Integer> result = preResults.get(i);
            List<Integer> newElement = new ArrayList<Integer>(result);
            newElement.add(num[index]);
            preResults.add(newElement);
        }
        return preResults;
    }
}