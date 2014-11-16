public class Solution {
    public static void main(String[] args) {
        int[] n = { 1, 3, 1, 1, 1 };

        Solution s = new Solution();
        System.out.println(s.search(n, 3));
    }

    public int search(int[] A, int target) {
        int index = -1;
        if (A != null && A.length > 0) {
            int l = 0, h = A.length - 1, mid = (l + h) / 2;
            while (l <= h) {
                if (A[mid] == target) {
                    index = mid;
                    break;
                }
                else {
                    if (A[mid] > target) {
                        if (A[mid] < A[l]) {
                            h = mid - 1;
                        }
                        else {
                            if (A[mid] > A[h]) {
                                if (A[h] < target) {
                                    h = mid - 1;
                                }
                                else {
                                    l = mid + 1;
                                }
                            }
                            else {
                                h = mid - 1;
                            }
                        }
                    }
                    else if (A[mid] < target) {
                        if (A[mid] < A[l]) {
                            if (A[h] < target) {
                                h = mid - 1;
                            }
                            else {
                                l = mid + 1;
                            }
                        }
                        else {
                            l = mid + 1;
                        }
                    }
                }
                mid = (l + h) / 2;
            }
        }

        return index;
    }
}
