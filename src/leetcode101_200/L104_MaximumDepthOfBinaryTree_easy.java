package leetcode101_200;

public class L104_MaximumDepthOfBinaryTree_easy {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 记录最大深度
    public int res = 0;
    // 记录遍历到的节点的深度
    public int depth = 0;

    // 主函数
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    // 前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth记录当前递归到的节点深度
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
