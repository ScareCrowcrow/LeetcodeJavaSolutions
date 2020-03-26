package InterviewQuestions;

// TAG: 动态规划

public class p47_medium {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        // init
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int j = 1; j < row; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
