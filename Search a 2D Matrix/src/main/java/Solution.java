public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                { 1, 3, 5, 7 }
        };
        int target = 8;
        System.out.println(s.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;

        if (m == 0 || n == 0) {
            return found;
        }

        int l = 0, h = m - 1, mid = 0;

        while (l <= h) {
            mid = (h - l) / 2 + l;
            if (matrix[mid][0] == target) {
                found = true;
                return found;
            }
            else if (matrix[mid][0] > target) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        int j = 0;
        if (l < m && target > matrix[l][0] && target <= matrix[l][n - 1]) {
            j = l;
        }
        else if (h >= 0 && target > matrix[h][0] && target <= matrix[h][n - 1]) {
            j = h;
        }
        else {
            return found;
        }

        l = 0;
        h = n - 1;
        mid = 0;

        while (l <= h) {
            mid = (h - l) / 2 + l;
            if (matrix[j][mid] == target) {
                found = true;
                return found;
            }
            else if (matrix[j][mid] > target) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return found;
    }
}