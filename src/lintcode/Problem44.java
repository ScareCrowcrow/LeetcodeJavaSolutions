package lintcode;

import java.util.List;

public class Problem44 {
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int N = nums.size();
        int[] help = new int[N];
        // help[i] 子数组必须以i位置结尾的情况下，累加和最小是多少？
        help[0] = nums.get(0);
        for (int i = 1; i < N; i++) {
            int p1 = nums.get(i);
            int p2 = nums.get(i) + help[i - 1];
            help[i] = Math.min(p1, p2);
        }
        // dp[i] 在0~i范围上，随意选一个子数组，累加和最小是多少？
        int[] dp = new int[N];
        int ans = help[0];
        dp[0] = help[0];
        for (int i = 1; i < N; i++) {
            int p1 = help[i];
            int p2 = dp[i - 1];
            dp[i] = Math.min(p1, p2);
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
