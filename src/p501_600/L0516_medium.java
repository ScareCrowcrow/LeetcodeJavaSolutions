package p501_600;

public class L0516_medium {
    /*
    * 当首尾的两个字符相等时：dp[0][n - 1] = dp[1][n - 2] + 2
    * 否则：dp[0][n - 1] = max( dp[1][n - 1], dp[0][n - 2])
    *
    * */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
