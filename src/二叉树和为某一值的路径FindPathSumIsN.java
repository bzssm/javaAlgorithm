import java.util.ArrayList;

public class 二叉树和为某一值的路径FindPathSumIsN {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Tree n1 = new Tree(10);
        Tree n2 = new Tree(5);
        Tree n3 = new Tree(12);
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        int target = 22;
        二叉树和为某一值的路径FindPathSumIsN ins = new 二叉树和为某一值的路径FindPathSumIsN();
        System.out.println(ins.findPath(n1, target));
    }

    public ArrayList<ArrayList<Integer>> findPath(Tree root, int target) {
        backTracking(root, target, new ArrayList<Integer>());
        return res;
    }

    public void backTracking(Tree node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.value);
        target -= node.value;
        if (target == 0 && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));

        backTracking(node.left, target, path);
        backTracking(node.right, target, path);

        path.remove(path.size() - 1);
    }
}
