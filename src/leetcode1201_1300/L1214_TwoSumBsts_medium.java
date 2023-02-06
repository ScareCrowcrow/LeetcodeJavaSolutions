package leetcode1201_1300;

public class L1214_TwoSumBsts_medium {
    // https://leetcode.cn/problems/two-sum-bsts/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) return false;
        if (root2 == null) return false;
        if( root1.val + root2.val == target) return true;
        if (root1.val + root2.val > target) {
            return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        }
        return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}
