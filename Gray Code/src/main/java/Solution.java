import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        List<Integer> result = solution.grayCode(n);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + ", ");
        }

    }

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (n < 0) {
            return results;
        }
        else if (n == 0) {
            results.add(0);
        }
        else {
            ArrayList<Integer> preResults = new ArrayList<Integer>();
            preResults.add(0);
            preResults.add(1);

            int i = 1;
            while (i < n) {
                // add '0'
                for (int j = 0; j < preResults.size(); j++) {
                    results.add(preResults.get(j));
                }

                // add '1'
                int temp = 1 << i;
                for (int j = preResults.size() - 1; j >= 0; j--) {
                    results.add(preResults.get(j) + temp);
                }
                preResults = results;
                results = new ArrayList<Integer>();
                i++;
            }

            results = preResults;
        }

        return results;
    }
}
