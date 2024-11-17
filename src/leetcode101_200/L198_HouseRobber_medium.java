package leetcode101_200;

public class L198_HouseRobber_medium {
    // https://leetcode-cn.com/problems/house-robber/
    /* 动态规划
    * 不能取相邻数的情况下的累加和最大是多少
    * 以i结尾的累加和
    * 1.只要i位置的数
    * 1.包含arr[i], 则不包含arr[i-1],dp[i-2]+arr[i]
    * 2.不包含arr[i],dp[i-1]
    * dp[i] = max(dp[i-1], dp[i-2]+arr[i], arr[i])
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], nums[i]), nums[i] + dp[i - 2]);
        }
        return dp[N - 1];
    }
}
