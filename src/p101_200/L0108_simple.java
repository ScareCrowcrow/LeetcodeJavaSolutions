package p101_200;

public class L0108_simple {
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(nums, left, p - 1);
        root.right = helper(nums, p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
