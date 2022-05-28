package leetcode201_300;

public class L270_ClosestBinarySearchTreeValue_easy {
    // https://leetcode.cn/problems/closest-binary-search-tree-value/
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

    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        while(root != null) {
            ans = Math.abs(root.val - target) < Math.abs(ans - target) ? root.val: ans;
            if(target < root.val) {
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ans;
    }
}
