package leetcode601_700;

import java.util.HashSet;
import java.util.Stack;

public class L653_TwoSumIVInputIsBST_easy {
    // https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return k == 0 ? true : false;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<Integer> set = new HashSet<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // 压左树
                stack.push(root);
                root = root.left;
            } else {
                // 左树空了 返回到上一层压右树
                root = stack.pop();
                if (set.contains(k - root.val)) {
                    return true;
                }
                set.add(root.val);
                root = root.right;
            }
        }
        return false;
    }
}
