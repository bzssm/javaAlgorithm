import java.sql.SQLOutput;
import java.util.Stack;

public class 反向打印链表ReverseLinkedList {
    /*
     * 反向打印链表
     * 1. 递归
     * 2. 头插
     * 头插法改变原始链表结构
     * 3. Stack
     * */

    public static void main(String[] args) {
        反向打印链表ReverseLinkedList ins = new 反向打印链表ReverseLinkedList();
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        n1.next = n2;
        n2.next = n3;
        //ins.recursive(n1);
        //ins.insertToHead(n1);
        //ins.useStack(n1);


    }


    public void recursive(LinkedListNode n) {
        if (n.next == null)
            System.out.println(n.value);
        else {
            recursive(n.next);
            System.out.println(n.value);
        }
    }

    public void insertToHead(LinkedListNode n) {
        LinkedList ll = new LinkedList();
        ll.head = new LinkedListNode(-1);
        LinkedListNode cn = n;
        ll.head.next = n;
        LinkedListNode second = cn;
        cn = cn.next;
        ll.head.next.next = null;

        while (cn != null) {

            ll.head.next = cn;
            cn = cn.next;
            ll.head.next.next = second;
            second = ll.head.next;
        }

        for (LinkedListNode node = ll.head.next; node != null; node = node.next)
            System.out.println(node.value);
    }

    public void useStack(LinkedListNode n) {
        Stack<LinkedListNode> stack = new Stack<>();
        while (n != null) {
            stack.push(n);
            n = n.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop().value);
        }
    }
}
