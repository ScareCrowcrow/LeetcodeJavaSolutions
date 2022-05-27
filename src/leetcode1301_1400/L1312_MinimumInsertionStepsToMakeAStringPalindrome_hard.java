package leetcode1301_1400;

public class L1312_MinimumInsertionStepsToMakeAStringPalindrome_hard {
    // https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    // 范围上尝试模型
    public int minInsertions(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        // dp[i][j]表示str[i...j]添加几个字符回文
        for (int i = 0; i < N - 1; i++) {
            // 倒数第2条对角线
            dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
        }
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                if (str[i] == str[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
