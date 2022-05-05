package leetcode101_200;

public class L101_SymmetricTree_easy {
    // https://leetcode-cn.com/problems/symmetric-tree/
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

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    // 一棵树是原始树  head1
    // 另一棵是翻面树  head2
    public static boolean isMirror(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 != null && head2 != null) {
            return head1.val == head2.val
                    && isMirror(head1.left, head2.right)
                    && isMirror(head1.right, head2.left);
        }
        // 一个为空，一个不为空  false
        return false;
    }
}
