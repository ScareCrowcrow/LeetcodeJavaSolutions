package leetcode001_100;

public class L062_UniquePaths_medium {
    // https://leetcode-cn.com/problems/unique-paths/
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

    // m 行
    // n 列
    // 下：m-1
    // 右：n-1
    public static int uniquePaths2(int m, int n) {
        // C(right, all)
        int right = n - 1;
        int all = m + n - 2;
        long o1 = 1;
        long o2 = 1;
        // o1乘进去的个数 一定等于 o2乘进去的个数
        for (int i = right + 1, j = 1; i <= all; i++, j++) {
            o1 *= i;
            o2 *= j;
            long gcd = gcd(o1, o2);
            o1 /= gcd;
            o2 /= gcd;
        }
        return (int) o1;
    }

    // 调用的时候，请保证初次调用时，m和n都不为0
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
