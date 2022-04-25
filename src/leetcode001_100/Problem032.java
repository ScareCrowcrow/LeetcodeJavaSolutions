package leetcode001_100;

public class Problem032 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        // dp[i] : 子串必须以i位置结尾的情况下，往左最远能扩出多长的有效区域
        int[] dp = new int[str.length];
        // dp[0] = 0; （  ）
        int pre = 0;
        int ans = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                // 当前谁和i位置的)，去配！
                pre = i - dp[i - 1] - 1; // 与str[i]配对的左括号的位置 pre
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
