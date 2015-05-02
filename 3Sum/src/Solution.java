import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums != null) {
            Arrays.sort(nums);
            int lastIndex3 = nums.length - 3;
            for (int i = 0; i <= lastIndex3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int p = i + 1;
                int q = nums.length - 1;
                while (p < q) {
                    if (p > i + 1 && nums[p] == nums[p - 1]) {
                        p++;
                        continue;
                    }
                    int sum = nums[i] + nums[p] + nums[q];
                    if (sum == 0) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[p]);
                        result.add(nums[q]);
                        results.add(result);
                        p++;
                        q--;
                    }
                    else if (sum < 0) {
                        p++;
                    }
                    else {
                        q--;
                    }
                }
            }
        }
        return results;
    }
}
