package leetcode201_300;

import java.util.Stack;

public class L285_InorderSuccessorInBST_medium {
    // https://leetcode-cn.com/problems/inorder-successor-in-bst/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre == p) {
                    return root;
                }
                pre = root;
                root = root.right;
            }
        }
        return null;
    }
}
