package p501_600;

public class L0516_medium {
    /*
    * 当首尾的两个字符相等时：dp[0][n - 1] = dp[1][n - 2] + 2
    * 否则：dp[0][n - 1] = max( dp[1][n - 1], dp[0][n - 2])
    *
    * */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
