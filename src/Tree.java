public class Tree {
    public int value;
    public Tree left = null;
    public Tree right = null;


    public Tree(int value) {
        this.value = value;
    }

    public static Tree build7NodesTree() {
        Tree n1 = new Tree(1);
        Tree n2 = new Tree(2);
        Tree n3 = new Tree(3);
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(5);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;
    }

    public static Tree buildBST(){
        Tree n1 = new Tree(5);
        Tree n2 = new Tree(3);
        Tree n3 = new Tree(7);
        Tree n4 = new Tree(2);
        Tree n5 = new Tree(4);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;
    }
}
