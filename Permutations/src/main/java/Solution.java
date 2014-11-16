import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 1, 2, 3 };
        List<List<Integer>> results = s.permute(num);
        for (List<Integer> element : results) {
            for (Integer i : element) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] num) {
        if (num != null && num.length > 0) {
            return permute(num, num.length);
        }
        else {
            return new ArrayList<List<Integer>>();
        }
    }

    public List<List<Integer>> permute(int[] num, int length) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (length == 1) {
            ArrayList<Integer> element = new ArrayList<Integer>();
            element.add(num[0]);
            results.add(element);
        }
        else if (length > 1) {
            List<List<Integer>> preResult = permute(num, length - 1);
            int i = num[length - 1];
            for (List<Integer> element : preResult) {
                for (int j = 0; j <= element.size(); j++) {
                    ArrayList<Integer> newElement = new ArrayList<Integer>();
                    newElement.addAll(element);
                    newElement.add(j, i);
                    results.add(newElement);
                }
            }
        }

        return results;
    }
}