package leetcode501_600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L589_NAryTreePreorderTraversal_easy {
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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res){
        res.add(root.val);
        for(Node child: root.children){
            if(child != null){
                helper(child, res);
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        for (Node child: root.children) {
            ans.addAll(preorder2(child));
        }
        return ans;
    }
}
