package leetcode501_600;

import java.util.ArrayList;
import java.util.List;

public class Problem590 {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> res = new ArrayList();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res){
        for(Node child: root.children){
            if(child != null){
                helper(child, res);
            }
        }
        res.add(root.val);
    }
}
