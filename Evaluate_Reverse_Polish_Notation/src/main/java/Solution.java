import java.util.Stack;

public class Solution {
    private static final String[] ops = { "+", "-", "*", "/" };

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isOperator(String op) {
        if (op == null || op.isEmpty()) {
            return false;
        }
        for (int i = 0; i < ops.length; i++) {
            if (op.equals(ops[i])) {
                return true;
            }
        }
        return false;
    }

    public int calExp(int a, int b, String op) {
        if (op == "+") {
            return a + b;
        }
        else if (op == "-") {
            return a-b;
        }
        else if (op == "*") {
            return a*b;
        }
        else if (op == "/") {
            return a/b;
        }
        else {
            try {
                throw new Exception("Unsupported operation '"+op+"'.");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
            
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i<tokens.length; i++){
            if (!isOperator(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            }
            else {
                if (stack.size()<2) {
                    try {
                        throw new Exception("Invalid tokens");
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -1;
                    }
                }
                else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(calExp(a, b, tokens[i]));
                }
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        else {
            try {
                throw new Exception("Invalid tokens");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
    }

}
