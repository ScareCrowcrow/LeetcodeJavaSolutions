package leetcode1001_1100;

public class L1022_SumOfRootToLeafBinaryNumbers_easy {
    // https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    int path = 0;
    int res = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            res += path << 1 | root.val;
            return;
        }
        // 前序位置
        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        path = path >> 1;
    }
}
