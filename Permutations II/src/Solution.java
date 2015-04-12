import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 1, 1, 2, 2 };
        List<List<Integer>> results = s.permuteUnique(num);
        for (List<Integer> element : results) {
            for (Integer i : element) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        if (num != null && num.length > 0) {
            Arrays.sort(num);
            permute(results, result, new boolean[num.length], num);
        }

        return results;
    }

    public void permute(List<List<Integer>> results, List<Integer> result, boolean[] used, int[] num) {
        if (result.size() == num.length) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i] || (i > 0 && num[i] == num[i - 1] && used[i - 1])) {
                continue;
            }
            used[i] = true;
            result.add(num[i]);
            permute(results, result, used, num);
            result.remove(result.size() - 1);
            used[i] = false;
        }
    }

}