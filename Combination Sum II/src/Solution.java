import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 10, 1, 2, 7, 1, 6, 5 };
        int target = 8;
        // int[] num = { 1, 2, 3 };
        // int target = 3;
        List<List<Integer>> results = s.combinationSum2(num, target);

        for (List<Integer> result : results) {
            for (Integer i : result) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(num);
        combination(results, result, num, target, 0);
        return results;
    }

    private void combination(List<List<Integer>> results, List<Integer> result, int[] num, int target,
            int start) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < num.length; i++) {
            result.add(num[i]);
            target -= num[i];
            combination(results, result, num, target, i + 1);
            target += num[i];
            result.remove(result.size() - 1);
            while (i + 1 < num.length && num[i + 1] == num[i]) {
                i++;
            }
        }
    }
}
