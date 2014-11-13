public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        boolean isAllNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isAllNine = false;
                break;
            }
        }
        int newLength = isAllNine ? digits.length + 1 : digits.length;
        int[] newDigits = new int[newLength];

        int t = 1;

        if (digits[digits.length - 1] + 1 == 10) {
            newDigits[newDigits.length - 1] = 0;
            t = 1;
        }
        else {
            newDigits[newDigits.length - 1] = digits[digits.length - 1] + 1;
            t = 0;
        }

        for (int i = digits.length - 2, j = newDigits.length - 2; i >= 0 && j >= 0; i--, j--) {
            if (digits[i] + t == 10) {
                newDigits[j] = 0;
            }
            else {
                newDigits[j] = digits[i] + t;
                t = 0;
            }
        }

        if (newDigits.length > digits.length) {
            newDigits[0] = 1;
        }
        return newDigits;
    }
}