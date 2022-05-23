package leetcode201_300;

// TAG: 树的中序遍历

public class L230_KthSmallestElementInABST_medium {
    // https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public int res = 0;
    public int rank = 0;
    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }
}