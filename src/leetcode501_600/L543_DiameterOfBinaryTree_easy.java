package leetcode501_600;

public class L543_DiameterOfBinaryTree_easy {
    // https://leetcode.cn/problems/diameter-of-binary-tree/
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

    public int diameterOfBinaryTree(TreeNode root) {
        return process(root).maxDistance-1;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int m, int h) {
            maxDistance = m;
            height = h;
        }

    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1, p2), p3);
        return new Info(maxDistance, height);
    }
}
