package p101_200;

// TAG: 递归

public class L0101_simple {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetricHelper(root.left, root.right);
    }
    boolean isSymmetricHelper(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null || l.val != r.val) return false;
        return isSymmetricHelper(l.left, r.right) && isSymmetricHelper(l.right, r.left);
    }
}
