public class 反转二叉树MirrorTree {
    public void mirror(Tree t) {
        if (t == null)
            return;
        Tree temp = t.left;
        t.left = t.right;
        t.right = temp;
        mirror(t.left);
        mirror(t.right);
    }
}
