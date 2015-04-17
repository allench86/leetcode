public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "111";
        String b = "1";
        System.out.println(s.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int flag = 0;
        char[] longString = a.toCharArray();
        char[] shortString = b.toCharArray();

        if (longString.length < shortString.length) {
            char[] t = longString;
            longString = shortString;
            shortString = t;
        }

        int i = longString.length - 1;
        int j = shortString.length - 1;

        while (j >= 0) {
            int x = longString[i] - '0';
            int y = shortString[j] - '0';

            int sum = x + y + flag;
            flag = sum / 2;
            char r = (char) ((sum % 2) + '0');
            result.insert(0, r);
            i--;
            j--;
        }

        while (i >= 0) {
            int x = longString[i] - '0';

            int sum = x + flag;
            flag = sum / 2;
            char r = (char) ((sum % 2) + '0');
            result.insert(0, r);
            i--;
        }

        if (flag == 1) {
            result.insert(0, '1');
        }

        return result.toString();
    }
}
