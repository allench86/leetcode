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
        List<Integer> results = new ArrayList<Integer>();
        if (n < 0) {
            return results;
        }
        else if (n == 0) {
            results.add(0);
        }
        else {
            generateGaryCode(n, results);
        }

        return results;
    }

    private void generateGaryCode(int n, List<Integer> results) {
        if (n == 1) {
            results.add(0);
            results.add(1);
            return;
        }

        generateGaryCode(n - 1, results);
        int t = 1 << n - 1;
        int size = results.size();

        for (int i = size - 1; i >= 0; i--) {
            results.add(results.get(i) + t);
        }
    }
}
