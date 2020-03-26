package p101_200;

import java.util.Arrays;

public class L0121_simple {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] delta = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++){
            delta[i-1] = prices[i] - prices[i-1];
        }
        int[] dp = new int[delta.length];
        dp[0] = Math.max(0, delta[0]);
        int profile = dp[0];
        for (int i = 1; i < delta.length; i++){
            dp[i] = Math.max(0, dp[i-1]+delta[i]);
            profile = Math.max(profile, dp[i]);
        }
        return profile;
    }
}
