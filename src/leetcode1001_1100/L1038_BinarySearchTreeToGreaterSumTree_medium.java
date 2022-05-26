package leetcode1001_1100;

public class L1038_BinarySearchTreeToGreaterSumTree_medium {
    // https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }
}
