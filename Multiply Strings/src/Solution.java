public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String num1 = "98";
        String num2 = "9";
        System.out.println(s.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
            boolean isNegative = false;
            if (num1.charAt(0) == '-') {
                isNegative = !isNegative;
                num1 = num1.substring(1);
            }

            if (num2.charAt(0) == '-') {
                isNegative = !isNegative;
                num2 = num2.substring(1);
            }

            String shortNum = num1.length() <= num2.length() ? num1 : num2;
            String longNum = num1.length() > num2.length() ? num1 : num2;

            for (int i = shortNum.length() - 1; i >= 0; i--) {
                char c = shortNum.charAt(i);
                StringBuilder tempResult = null;
                if (c != '0') {
                    tempResult = stringMultiplyChar(longNum, c);
                    leftShiftString(tempResult, shortNum.length() - i - 1);
                }
                else {
                    tempResult = new StringBuilder();
                    tempResult.append('0');
                }
                result = stringSum(result, tempResult);
            }

            if (isNegative) {
                result.insert(0, '-');
            }
        }

        return result.toString();
    }

    private StringBuilder stringMultiplyChar(String s, char c) {
        StringBuilder result = new StringBuilder();
        int index = s.length() - 1;
        int flag = 0;
        while (index >= 0) {
            char c1 = s.charAt(index);
            int r = (c1 - '0') * (c - '0') + flag;
            flag = r / 10;
            result.append(String.valueOf(r % 10));
            index--;
        }

        if (flag != 0) {
            result.append(String.valueOf(flag));
        }

        return result.reverse();
    }

    private StringBuilder stringSum(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();

        int flag = 0;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        while (indexA >= 0 && indexB >= 0)
        {
            char c1 = a.charAt(indexA);
            char c2 = b.charAt(indexB);

            int sum = (c1 - '0') + (c2 - '0') + flag;
            flag = sum / 10;
            result.append(String.valueOf(sum % 10));
            indexA--;
            indexB--;
        }

        while (indexA >= 0) {
            char c1 = a.charAt(indexA);

            int sum = c1 - '0' + flag;
            flag = sum / 10;
            result.append(String.valueOf(sum % 10));
            indexA--;
        }

        while (indexB >= 0) {
            char c2 = b.charAt(indexB);

            int sum = c2 - '0' + flag;
            flag = sum / 10;
            result.append(String.valueOf(sum % 10));
            indexB--;
        }

        if (flag != 0) {
            result.append(String.valueOf(flag));
        }

        return result.reverse();
    }

    private void leftShiftString(StringBuilder s, int leftShiftN) {
        while (leftShiftN > 0) {
            s.append('0');
            leftShiftN--;
        }
    }

}
