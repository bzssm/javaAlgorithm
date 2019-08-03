public class 复杂链表的复制CopyComplexLinkedList {
    public static RandomLinkedListNode copy(RandomLinkedListNode head) {
        //第一步，在每个节点后面复制当前节点
        // 1 -> 2 -> 3 -> 4:
        // 1->1->2->2->3->3->4->4
        RandomLinkedListNode cn = head;
        while (cn != null) {
            RandomLinkedListNode cnCopy = new RandomLinkedListNode(cn.value);
            cnCopy.next = cn.next;
            cn.next = cnCopy;
            cn = cnCopy.next;
        }

        //第二步，复制random链接
        cn = head;
        while (cn != null) {
            RandomLinkedListNode cnCopy = cn.next;
            cnCopy.random = cn.random.next;
            cn = cnCopy.next;
        }

        //第三步，拆分链表
        cn = head;
        RandomLinkedListNode copyHead = cn.next;
        while (cn.next != null) {
            RandomLinkedListNode copy = cn.next;
            cn.next = copy.next;
            //copy.next = copy.next.next;
            cn = copy;
        }
        return copyHead;

    }

    public static void main(String[] args) {
        RandomLinkedListNode n1 = new RandomLinkedListNode(1);
        RandomLinkedListNode n2 = new RandomLinkedListNode(2);
        RandomLinkedListNode n3 = new RandomLinkedListNode(3);
        RandomLinkedListNode n4 = new RandomLinkedListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n3;
        n3.random = n1;
        n2.random = n4;
        n4.random = n2;
        RandomLinkedListNode nCopy = 复杂链表的复制CopyComplexLinkedList.copy(n1);
        System.out.println(nCopy.value);

    }
}
