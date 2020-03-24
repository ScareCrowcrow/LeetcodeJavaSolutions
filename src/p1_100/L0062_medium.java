package p1_100;

// TAG: 动态规划
/*
* 动态规划的步骤：
* 1、确定状态变量
* 2、初始化
* 3、列出状态转移方程
* 4、返回结果
* */

public class L0062_medium {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // init
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
