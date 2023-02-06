package leetcode2301_2400;

public class L2331_EvaluateBooleanBinaryTree_easy {
    // https://leetcode.cn/problems/evaluate-boolean-binary-tree/
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }

        public boolean evaluateTree(TreeNode root) {
            if(root.left == null) {
                return root.val == 1;
            }
            if(root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}
