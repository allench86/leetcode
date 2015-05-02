import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length >= 2) {
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    List<Integer> value = map.get(nums[i]);
                    value.add(i);
                }
                else {
                    List<Integer> value = new ArrayList<Integer>();
                    value.add(i);
                    map.put(nums[i], value);
                }
            }

            Iterator<Integer> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                int rest = target - key;
                if (map.containsKey(rest)) {
                    if (rest != key) {
                        List<Integer> v1 = map.get(key);
                        List<Integer> v2 = map.get(rest);
                        int[] result = new int[2];
                        int index1 = Math.min(v1.get(0) + 1, v2.get(0) + 1);
                        int index2 = Math.max(v1.get(0) + 1, v2.get(0) + 1);
                        result[0] = index1;
                        result[1] = index2;
                        return result;
                    }
                    else {
                        List<Integer> v = map.get(key);
                        if (v.size() >= 2) {
                            int[] result = new int[2];
                            int index1 = Math.min(v.get(0) + 1, v.get(1) + 1);
                            int index2 = Math.max(v.get(0) + 1, v.get(1) + 1);
                            result[0] = index1;
                            result[1] = index2;
                            return result;
                        }
                    }
                }
            }
        }
        return null;
    }
}
