package leetcode101_200;

public class Problem101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetricHelper(root.left, root.right);
    }
    boolean isSymmetricHelper(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null || l.val != r.val) return false;
        return isSymmetricHelper(l.left, r.right) && isSymmetricHelper(l.right, r.left);
    }
}
