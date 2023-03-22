package leetcode101_200;

public class L156_BinaryTreeUpsideDown_medium {
    // https://leetcode.cn/problems/binary-tree-upside-down/
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { // root为空或是叶子节点返回
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left); // 只需递归处理左子树，不需要递归右子树，右子树都是叶子节点

        root.left.left  = root.right; // 三角关系翻转
        root.left.right = root;

        // 根或子树的root变为右叶子节点
        root.left = null;
        root.right = null;
        return newRoot; // 同链表翻转，返回整颗树最左的叶子节点
    }
}
