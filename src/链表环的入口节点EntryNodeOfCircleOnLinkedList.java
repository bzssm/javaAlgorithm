public class 链表环的入口节点EntryNodeOfCircleOnLinkedList {
    /*
     * 快慢指针法
     * p1p2同时开始
     * p1一次走一步
     * p2一次走两步
     * 在换上相遇
     * 相遇的时候，p2从头开始再走
     * 再次相遇就是入口节点*/

    /*
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     *                ^                                   |
     *                +-----------------------------------+
     * */
    public static void main(String[] args) {
        LinkedListNode n0 = new LinkedListNode(0);
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);
        LinkedListNode n7 = new LinkedListNode(7);
        LinkedListNode n8 = new LinkedListNode(8);
        LinkedListNode n9 = new LinkedListNode(9);
        LinkedListNode n10 = new LinkedListNode(10);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n3;
        LinkedList ll = new LinkedList(n1);
        链表环的入口节点EntryNodeOfCircleOnLinkedList ins = new 链表环的入口节点EntryNodeOfCircleOnLinkedList();
        System.out.println(ins.entryNodeOfLoop(ll).value);
    }

    public LinkedListNode entryNodeOfLoop(LinkedList ll) {
        LinkedListNode slow = ll.head;
        LinkedListNode fast = ll.head;
        do {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        } while (slow != fast);
        fast = ll.head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
