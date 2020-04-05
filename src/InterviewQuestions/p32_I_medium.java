package InterviewQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p32_I_medium {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return  new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            result.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }

}
