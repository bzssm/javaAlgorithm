import java.util.Stack;

public class 包含最小值查找的栈MinStack {
    /*
     * 放的时候，每次记录当前dataStack位置最小值
     * |  |                 | |
     * |  |                 | |
     * |1 |                 |1|
     * |9 |                 |4|
     * |4 |                 |4|
     * |13|                 |6|
     * |6 |                 |6|
     * +--+                 +-+
     *dataStack           minStack
     * 取出时，两边同时取出，保证minStack.peek()是当前dataStack位置所对应的最小值
     * */

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int n) {
        dataStack.push(n);
        if (minStack.empty()) {
            minStack.push(n);
        } else {
            if (minStack.peek() <= n)
                minStack.push(minStack.peek());
            else
                minStack.push(n);
        }
    }

    public int pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public int peek() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
