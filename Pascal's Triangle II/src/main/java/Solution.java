import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numRows = 0;
        List<Integer> results = s.getRow(numRows);
        for (Integer element : results) {
            System.out.print(element + ", ");
        }
    }

    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                row[i] = 1;
            }
            else if (i == 1) {
                row[0] = 1;
                row[1] = 1;
            }
            else {
                row[i] = 1;
                for (int j = i - 1; j > 0; j--) {
                    row[j] = row[j] + row[j - 1];
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            results.add(row[i]);
        }

        return results;
    }
}