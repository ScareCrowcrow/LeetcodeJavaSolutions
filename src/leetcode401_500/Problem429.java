package leetcode401_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem429 {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            res.add(new ArrayList());
            int level_length = queue.size();
            for(int i = 0; i < level_length; i++){
                Node cur = queue.remove();
                res.get(level).add(cur.val);
                for(Node child: cur.children){
                    if(child != null) queue.add(child);
                }
            }
            level++;
        }
        return res;
    }
}
