public class Solution {
    public boolean search(int[] A, int target) {
        if (A != null && A.length > 0) {
            int l = 0, h = A.length - 1, mid = (l + h) / 2;
            while (l <= h) {
                mid = (l + h) / 2;
                if (A[mid] == target) {
                    return true;
                }
                if (A[mid] > A[l]) {
                    if (target == A[l]) {
                        return true;
                    }
                    else if (target > A[l] && target < A[mid]) {
                        h = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                else if (A[mid] < A[l]) {
                    if (target == A[h]) {
                        return true;
                    }
                    else if (target > A[mid] && target < A[h]) {
                        l = mid + 1;
                    }
                    else {
                        h = mid - 1;
                    }
                }
                else {
                    l++;
                }
            }
        }

        return false;
    }
}