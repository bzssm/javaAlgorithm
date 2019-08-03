public class 合并两个有序链表MergeTwoSortedLL {
    public LinkedListNode recursiveMerge(LinkedListNode n1, LinkedListNode n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        if (n1.value < n2.value) {
            n1.next = recursiveMerge(n1.next, n2);
            return n1;
        } else {
            n2.next = recursiveMerge(n1, n2.next);
            return n2;
        }
    }

    public LinkedListNode iterMerge(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode res = new LinkedListNode(-1);
        LinkedListNode cn = res;
        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                cn.next = n1;
                n1 = n1.next;
            } else {
                cn.next = n2;
                n2 = n2.next;
            }
            cn = cn.next;
        }
        if (n1 == null)
            cn.next = n2;
        if (n2 == null)
            cn.next = n1;
        return res.next;

    }
}
