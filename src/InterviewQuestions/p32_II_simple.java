package InterviewQuestions;

import java.util.*;

public class p32_II_simple {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++){
                TreeNode cur = queue.remove();
                tmp.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            // 当结果为奇数个，当前在偶数层，逆序当前层
            if (res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
