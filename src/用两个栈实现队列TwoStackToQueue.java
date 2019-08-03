import java.util.Stack;

public class 用两个栈实现队列TwoStackToQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void pushLeft(int n) {
        inStack.push(n);
    }

    public int popRight() throws Exception {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.empty())
            throw new Exception("queue is empty");
        return outStack.pop();
    }
}
