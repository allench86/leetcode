//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome("1a2"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        int l = nextLetterIndex(s, 0, true);
        int r = nextLetterIndex(s, s.length() - 1, false);
        while (l < r) {
            String a = String.valueOf(s.charAt(l));
            String b = String.valueOf(s.charAt(r));
            if (!a.equalsIgnoreCase(b)) {
                return false;
            }

            l = nextLetterIndex(s, l + 1, true);
            r = nextLetterIndex(s, r - 1, false);
        }
        return true;
    }

    private int nextLetterIndex(String s, int start, boolean increase) {
        if (increase) {
            while (start < s.length()) {
                char c = s.charAt(start);
                if (isLetterOrNum(c)) {
                    return start;
                }
                start++;
            }
        }
        else {
            while (start >= 0) {
                char c = s.charAt(start);
                if (isLetterOrNum(c)) {
                    return start;
                }
                start--;
            }
        }
        return -1;
    }

    private boolean isLetterOrNum(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }
}
