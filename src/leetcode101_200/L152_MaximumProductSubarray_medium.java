package leetcode101_200;

public class L152_MaximumProductSubarray_medium {
    // https://leetcode-cn.com/problems/maximum-product-subarray/
    // 计算以任意位置结尾的最大乘积，然后取最大
    // case1. 只考虑当前值
    // case2. 当前值 * dp[i-1]
    // case3. 当前值 * 前i-1个数的最小乘积(有负数情况)
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curmin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int curmax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = curmin;
            max = curmax;
            ans  = Math.max(ans, max);
        }
        return ans;
    }
}
