import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 1;
        List<List<Integer>> coms = s.combinationSum(candidates, target);
        if (coms != null) {
            for (List<Integer> l : coms) {
                for (Integer i : l) {
                    System.out.print(i + ", ");
                }
                System.out.println();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }

        Arrays.sort(candidates);

        return helper(candidates, target, candidates.length);
    }

    private List<List<Integer>> helper(int[] candidates, int target, int preLength) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (target <= 0) {
            return results;
        }

        int mIndex = 0;
        if (candidates[mIndex] > target) {
            return results;
        }

        while (mIndex < preLength && candidates[mIndex] <= target) {
            mIndex++;
        }

        mIndex = mIndex - 1;

        while (mIndex >= 0) {
            int nextTarget = target - candidates[mIndex];
            if (nextTarget > 0) {
                List<List<Integer>> preResults = helper(candidates, nextTarget, mIndex + 1);
                if (preResults != null && !preResults.isEmpty()) {
                    for (List<Integer> r : preResults) {
                        r.add(candidates[mIndex]);
                        results.add(r);
                    }
                }
            }
            else if (nextTarget == 0) {
                List<Integer> element = new ArrayList<Integer>();
                element.add(candidates[mIndex]);
                results.add(element);
            }
            mIndex--;
        }

        return results;
    }
}
