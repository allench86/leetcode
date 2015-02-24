import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int n = 4;
        int k = 1;
        List<List<Integer>> coms = s.combine(n, k);
        for (List<Integer> l : coms) {
            for (Integer i : l) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList<Integer>();

        if (n >= k) {
            generate(n, k, results, r, 1);
        }
        return results;
    }

    public void generate(int n, int k, List<List<Integer>> results, List<Integer> r, int nextNum) {
        if (r.size() == k) {
            results.add(new ArrayList<Integer>(r)); // Important! copy the current state of r, otherwise, elements in r
                                                    // will be removed.
            return;
        }

        for (int i = nextNum; i <= n; i++) {
            r.add(i);
            generate(n, k, results, r, i + 1);
            r.remove(r.size() - 1);
        }
    }
}
