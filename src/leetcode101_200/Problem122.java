package leetcode101_200;

public class Problem122 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        // 找每一个上坡即可
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i-1], 0);
        }
        return ans;
    }
}
