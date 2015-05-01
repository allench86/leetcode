import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums.length >= 4) {
            Arrays.sort(nums);
            int lastIndex4 = nums.length - 4;
            int lastIndex3 = nums.length - 3;

            for (int i = 0; i <= lastIndex4; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j <= lastIndex3; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int p = j + 1;
                    int q = nums.length - 1;

                    while (p < q) {
                        if (p > j + 1 && nums[p] == nums[p - 1]) {
                            p++;
                            continue;
                        }
                        int sum = nums[i] + nums[j] + nums[p] + nums[q];
                        if (sum == target) {
                            List<Integer> result = new ArrayList<Integer>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[p]);
                            result.add(nums[q]);
                            p++;
                            q--;
                            results.add(result);
                        }
                        else if (sum > target) {
                            q--;
                        }
                        else {
                            p++;
                        }
                    }
                }
            }
        }

        return results;
    }
}
