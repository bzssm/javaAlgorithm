import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下遍历二叉树各种打印方式BFS {

    public static void main(String[] args) {
        Tree t = Tree.build7NodesTree();
        从上往下遍历二叉树各种打印方式BFS ins = new 从上往下遍历二叉树各种打印方式BFS();
        System.out.println(ins.bfsNormalPrint(t));
        System.out.println(ins.bfsLayerPrint(t));
        System.out.println(ins.bfsZigzagPrint(t));


    }

    public ArrayList<Integer> bfsNormalPrint(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree cn = queue.poll();
            res.add(cn.value);
            if (cn.left != null)
                queue.add(cn.left);
            if (cn.right != null)
                queue.add(cn.right);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> bfsLayerPrint(Tree root) {
        Queue<ArrayList<Tree>> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(new ArrayList<Tree>() {{
            add(root);
        }});
        while (!queue.isEmpty() && !queue.peek().isEmpty()) {
            ArrayList<Tree> cl = queue.poll();
            ArrayList<Integer> currentLayerValue = new ArrayList<>();
            cl.forEach(x -> currentLayerValue.add(x.value));
            res.add(currentLayerValue);
            ArrayList<Tree> nl = new ArrayList<>();
            cl.forEach(x -> {
                if (x.left != null) nl.add(x.left);
                if (x.right != null) nl.add(x.right);
            });
            queue.add(nl);
        }
        return res;
    }

    public ArrayList<Integer> bfsZigzagPrint(Tree root) {
        ArrayList<ArrayList<Integer>> layerPrint = this.bfsLayerPrint(root);
        for (int i = 1; i < layerPrint.size(); i += 2) {
            Collections.reverse(layerPrint.get(i));
        }
        ArrayList<Integer> res = new ArrayList<>();
        layerPrint.forEach(x -> x.forEach(y -> res.add(y)));
        return res;
    }
}
