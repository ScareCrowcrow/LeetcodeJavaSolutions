package leetcode1301_1400;

public class L1388_PizzaWith3nSlices_hard {
    // https://leetcode.cn/problems/pizza-with-3n-slices/
    public int maxSizeSlices(int[] slices) {
        int[] slices1 = new int[slices.length - 1];
        // 删除序列中的第一个数
        System.arraycopy(slices, 1, slices1, 0, slices.length - 1);
        int[] slices2 = new int[slices.length - 1];
        // 删除序列中的最后一个数
        System.arraycopy(slices, 0, slices2, 0, slices.length - 1);
        int ans1 = calculate(slices1);
        int ans2 = calculate(slices2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;
        // // 3n个数中不连续且长度为n的子序列的最大累加和
        // dp[i][j] 表示在前i个数中选择了j个不相邻的数的最大累加和
        // case1: 选择了第i个数，那么第i-1个数不能被选择，相当于需要在前i−2个数中选择j−1个: dp[i][j]=dp[i−2][j−1]+slices[i]
        // case2: 没有选择第i个数，那么需要在前i−1个数中选择j个: dp[i][j]=dp[i−1][j]
        // 汇总: dp[i][j]=max(dp[i−2][j−1]+slices[i],dp[i−1][j])
        int[][] dp = new int[n + 1][choose + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= choose; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }
        return dp[n][choose];
    }
}
