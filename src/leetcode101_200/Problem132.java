package leetcode101_200;

public class Problem132 {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        boolean[][] checkMap = createCheckMap(str, N);
        int[] dp = new int[N + 1];
        dp[N] = 0;
        // dp[i]表示从i开始切成几部分后均为回文串，dp[0]即为最后形成的回文串数量
        for (int i = N - 1; i >= 0; i--) {
            if (checkMap[i][N - 1]) {
                dp[i] = 1;
            } else {
                int next = Integer.MAX_VALUE;
                for (int j = i; j < N; j++) {
                    if (checkMap[i][j]) {
                        next = Math.min(next, dp[j + 1]);
                    }
                }
                dp[i] = 1 + next;
            }
        }
        return dp[0] - 1;
    }

    // 生成预处理结构，任意str[L...R]是否为回文
    public boolean[][] createCheckMap(char[] str, int N) {
        boolean[][] ans = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) {
            ans[i][i] = true;
            ans[i][i + 1] = str[i] == str[i + 1];
        }
        ans[N - 1][N - 1] = true;
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                ans[i][j] = str[i] == str[j] && ans[i + 1][j - 1];
            }
        }
        return ans;
    }
}
