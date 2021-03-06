package p101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0102_medium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
           res.add(new ArrayList<>());
           int level_length = queue.size();
           for (int i = 0; i < level_length; i++){
               TreeNode cur = queue.remove();
               res.get(level).add(cur.val);
               if (cur.left != null) queue.add(cur.left);
               if (cur.right != null) queue.add(cur.right);
           }
           level++;
        }
        return res;
    }
}
