package leetcode101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L144_BinaryTreePreorderTraversal_easy {
    // https://leetcode.cn/problems/binary-tree-preorder-traversal/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ans = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }
}
