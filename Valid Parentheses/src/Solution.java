//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();
                if (chars[i] == ')' && p != '(') {
                    return false;
                }
                else if (chars[i] == ']' && p != '[') {
                    return false;
                }
                else if (chars[i] == '}' && p != '{') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
