import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numRows = 10;
        List<List<Integer>> results = s.generate(numRows);
        for (List<Integer> element : results) {
            for (Integer i : element) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            if (results.isEmpty()) {
                List<Integer> firstLavel = new ArrayList<Integer>();
                firstLavel.add(1);
                results.add(firstLavel);
            }
            else {
                List<Integer> lastLavel = results.get(results.size() - 1);
                List<Integer> nextLavel = new ArrayList<Integer>();
                for (int j = 0; j < lastLavel.size(); j++) {
                    if (j == 0) {
                        nextLavel.add(1);
                    }
                    else {
                        nextLavel.add(lastLavel.get(j) + lastLavel.get(j - 1));
                    }
                }
                nextLavel.add(1);
                results.add(nextLavel);
            }
        }
        return results;
    }
}