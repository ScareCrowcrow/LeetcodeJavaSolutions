package InterviewQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offerII_044_medium {
    // https://leetcode.cn/problems/hPov7L/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int curLevelMaxVal = Integer.MIN_VALUE;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                curLevelMaxVal = Math.max(curLevelMaxVal, cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(curLevelMaxVal);
        }
        return ans;
    }
}
