import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<Integer> current = triangle.get(triangle.size() - 1);
        int[] minSum = new int[current.size()];

        for (int i = 0; i < minSum.length; i++) {
            minSum[i] = current.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                minSum[j] = Math.min(minSum[j], minSum[j + 1]) + current.get(j);
            }
        }

        return minSum[0];
    }
}
