import java.util.Stack;

class MinStack {
    Stack<Integer> elements = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        elements.push(x);

        if (min.isEmpty() || min.peek() <= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (!elements.isEmpty()) {
            if (!min.isEmpty()) {
                if (elements.peek().equals(min.peek())) {
                    min.pop();
                }
            }
            elements.pop();
        }

    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
