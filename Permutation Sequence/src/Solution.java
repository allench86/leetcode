//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3, k = 1;
        System.out.println(s.getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        List<Character> chars = new ArrayList<Character>();
        for (int i = 0; i <= n; i++) {
            chars.add((char) ('0' + i));
        }

        for (int i = 1; i < n; i++) {
            int group = (int) Math.ceil(k * 1.0 / factorial);
            result.append(chars.remove(group));
            k = k - factorial * (group - 1);
            factorial /= (n - i);
        }

        result.append(chars.remove(1));

        return result.toString();
    }
}
