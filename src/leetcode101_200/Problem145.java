package leetcode101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root.left != null) helper(root.left, res);
        if(root.right != null) helper(root.right, res);
        res.add(root.val);
    }
}
