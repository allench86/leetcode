import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] n = { 1, 2, 2, 2 };
        List<List<Integer>> r = s.subsetsWithDup(n);
        for (List<Integer> a : r) {
            for (Integer i : a) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        if (num.length == 0) {
            return results;
        }
        Arrays.sort(num);
        int lastAddNum = 1;
        for (int i = 0; i < num.length; i++) {
            int size = results.size();
            int j = i > 0 && num[i] == num[i - 1] ? size - lastAddNum : 0;
            lastAddNum = 0;
            for (; j < size; j++) {
                List<Integer> element = new ArrayList<Integer>(results.get(j));
                element.add(num[i]);
                results.add(element);
                lastAddNum++;
            }
        }

        return results;
    }
}