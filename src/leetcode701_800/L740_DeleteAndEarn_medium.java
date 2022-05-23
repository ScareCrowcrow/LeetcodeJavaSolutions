package leetcode701_800;

public class L740_DeleteAndEarn_medium {
    // https://leetcode.cn/problems/delete-and-earn/
    // 数组转换后即为打家劫舍问题
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i ++) {
            trans[nums[i]] += nums[i];
        }

        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + trans[i]);
        }

        return dp[dp.length - 1];
    }
}
