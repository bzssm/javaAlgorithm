import java.util.Stack;

public class 栈的压入弹出序列IsPopOrder {
    public static void main(String[] args) {
        栈的压入弹出序列IsPopOrder ins = new 栈的压入弹出序列IsPopOrder();
        int[] pushSeq = new int[]{1, 2, 3, 4, 5};
        int[] popSeq = new int[]{4, 3, 5, 1, 2};
        System.out.println(ins.isPopOrder(pushSeq, popSeq));
    }

    public boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        int n = pushSeq.length;
        //新建一个Stack模拟压入弹出操作
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSeq[pushIndex]);
            //每次放进去一个数，就判断当前这个数是不是popSeq[popIndex]
            //如果是，就直接弹出，popIndex+1，直到不是就再往里放
            while (popIndex < n && !stack.empty() && stack.peek() == popSeq[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.empty();
    }
}
