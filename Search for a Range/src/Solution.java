//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] results = s.searchRange(A, target);

        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    public int[] searchRange(int[] A, int target) {
        int[] results = { -1, -1 };
        int index = binarySearch(A, 0, A.length - 1, target);

        if (index != -1) {
            results[0] = index;
            results[1] = index;

            int leftBoundary = binarySearch(A, 0, results[0] - 1, target);
            while (leftBoundary != -1) {
                results[0] = leftBoundary;
                leftBoundary = binarySearch(A, 0, results[0] - 1, target);
            }

            int rightBoundary = binarySearch(A, results[1] + 1, A.length - 1, target);
            while (rightBoundary != -1) {
                results[1] = rightBoundary;
                rightBoundary = binarySearch(A, results[1] + 1, A.length - 1, target);
            }

        }

        return results;
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        int result = -1;
        if (start > end) {
            return result;
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                result = mid;
                break;
            }
            else if (A[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return result;
    }
}
