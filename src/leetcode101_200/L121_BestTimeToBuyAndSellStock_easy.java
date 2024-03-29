package leetcode101_200;

public class L121_BestTimeToBuyAndSellStock_easy {
    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
