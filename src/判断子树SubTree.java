public class 判断子树SubTree {

    public static void main(String[] args) {
        Tree t1 = new Tree(8);
        Tree t2 = new Tree(8);
        Tree t3 = new Tree(7);
        Tree t4 = new Tree(9);
        Tree t5 = new Tree(2);
        Tree t6 = new Tree(1);
        Tree t7 = new Tree(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Tree t8 = new Tree(8);
        Tree t9 = new Tree(9);
        Tree t10 = new Tree(2);
        t8.left = t9;
        t8.right = t10;

        判断子树SubTree ins = new 判断子树SubTree();
        System.out.println(ins.hasSubTree(t1, t8));
    }

    // t1 parent
    // t2 subtree
    public boolean isSubTree(Tree t1, Tree t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.value != t2.value)
            return false;
        return isSubTree(t1.left, t2.left) && isSubTree(t1.right, t2.right);
    }

    //driver
    //main function
    public boolean hasSubTree(Tree t1, Tree t2) {
        if (t1 == null)
            return false;
        return isSubTree(t1, t2) || hasSubTree(t1.left, t2) || hasSubTree(t1.right, t2);
    }
}
