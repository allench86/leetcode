//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(18));
    }

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        HashSet<Integer> checked = new HashSet<Integer>();
        checked.add(n);
        int t = n;
        do {
            List<Integer> splited = splitNum(t);
            t = 0;
            for (Integer i : splited) {
                t += i * i;
            }

            if (t == 1) {
                return true;
            }
            else if (checked.contains(t)) {
                return false;
            }
            checked.add(t);
        } while (t != 1);
        return true;
    }

    private List<Integer> splitNum(int n) {
        List<Integer> result = new ArrayList<Integer>();
        while (n > 0) {
            result.add(n % 10);
            n = n / 10;
        }
        return result;
    }
}
