package leetcode201_300;

public class L236_LowestCommonAncestorOfABinaryTree_medium {
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        if (rightNode == null){
            return leftNode;
        }
        if (leftNode == null){
            return rightNode;
        }
        return root;
    }
}
