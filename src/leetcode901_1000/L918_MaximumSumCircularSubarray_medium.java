package leetcode901_1000;

public class L918_MaximumSumCircularSubarray_medium {
    // https://leetcode.cn/problems/maximum-sum-circular-subarray/
    public int maxSubarraySumCircular(int[] nums) {
        // case1. 最大连续子数组在数组中间
        // case2. 最大连续子数组在数组两边，这就需要求出最小连续子数组，然后用数组和减去最小连续子数组
        //特殊情况是数组全为负，此时需要返回数组中的最大元素，也可以理解为是最大连续子数组
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum_num = nums[0];
        int[] dp_max = new int[n];
        dp_max[0] = nums[0];
        int[] dp_min = new int[n];
        dp_min[0] = nums[0];
        int max_dp = nums[0], min_dp = nums[0];
        for(int i = 1; i < n; i ++)
        {
            dp_max[i] = Math.max(dp_max[i - 1] + nums[i], nums[i]);
            max_dp = Math.max(max_dp, dp_max[i]);
            dp_min[i] = Math.min(dp_min[i - 1] + nums[i], nums[i]);
            min_dp = Math.min(min_dp, dp_min[i]);
            sum_num += nums[i];
        }
        int max1 = max_dp;
        int max2 = sum_num - min_dp;
        // 特殊情况是数组全为负，此时需要返回数组中的最大元素，也可以理解为是最大连续子数组
        if(max2 == 0)
            return max1;
        return Math.max(max1, max2);
    }
}
