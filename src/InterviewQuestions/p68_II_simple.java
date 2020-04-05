package InterviewQuestions;

public class p68_II_simple {
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
