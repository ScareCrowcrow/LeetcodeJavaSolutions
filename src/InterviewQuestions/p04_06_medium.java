package InterviewQuestions;

public class p04_06_medium {
    // https://leetcode.cn/problems/successor-lcci/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return null;
        }
        if(p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root: node;
    }
}
