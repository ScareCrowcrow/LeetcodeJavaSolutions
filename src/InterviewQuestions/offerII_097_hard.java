package InterviewQuestions;

public class offerII_097_hard {
    // https://leetcode-cn.com/problems/21dk04/
    // 动态规划: 样本对应模型
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-1](if s[i] == t[j])
    public int numDistinct(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int N = s.length;
        int M = t.length;
        int[][] dp = new int[N][M];
        // s[0..0] T[0..0] dp[0][0]
        dp[0][0] = s[0] == t[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            dp[i][0] = s[i] == t[0] ? (dp[i - 1][0] + 1) : dp[i - 1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= Math.min(i, M - 1); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s[i] == t[j]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[N - 1][M - 1];
    }
}
