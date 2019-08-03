public class 链表倒数第K个节点ReverseKthNode {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        LinkedList ll = new LinkedList(n1);
        链表倒数第K个节点ReverseKthNode ins = new 链表倒数第K个节点ReverseKthNode();
        System.out.println(ins.reverseKthNode(ll, 4).value);
    }

    /*
     * 双指针法
     * P1先移动K个
     * P2从头开始
     * P1结束的时候
     * P2刚好在N-k
     *
     * (假设k<len(l))
     * */
    public LinkedListNode reverseKthNode(LinkedList l, int k) {
        LinkedListNode p1 = l.head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        LinkedListNode p2 = l.head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
