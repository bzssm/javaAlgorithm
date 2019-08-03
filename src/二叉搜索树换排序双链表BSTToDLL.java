public class 二叉搜索树换排序双链表BSTToDLL {
    public Tree prev = null;
    public Tree head = null;

    public Tree bst2dll(Tree root){
        inOrder(root);
        return head;
    }

    public void inOrder(Tree node){
        if (node == null)
            return;
        inOrder(node.left);
        node.left = prev;
        if (prev!=null){
            prev.right = node;
        }
        prev = node;
        if(head == null)
            head = node;
        inOrder(node.right);
    }
}
