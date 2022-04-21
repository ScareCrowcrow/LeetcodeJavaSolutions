package leetcode1001_1100;

public class Problem1029 {
    public int twoCitySchedCost1(int[][] costs) {
        if (costs == null || costs.length < 2 || (costs.length & 1) != 0) {
            return 0;
        }
        int N = costs.length; // 人数一定是偶数，所以才能平分，A N /2 B N/2
        int M = N >> 1; // M = N / 2 要去A区域的人
        return process1(costs, 0, M);
    }

    public static int process1(int[][] costs, int index, int rest) {
        if (index == costs.length) {
            return 0;
        }
        // 还剩下的人！
        if (costs.length - index == rest) {
            return costs[index][0] + process1(costs, index + 1, rest - 1);
        }
        if (rest == 0) {
            return costs[index][1] + process1(costs, index + 1, rest);
        }
        // 当前面试者，可以去A，或者去B
        int p1 = costs[index][0] + process1(costs, index + 1, rest - 1);
        int p2 = costs[index][1] + process1(costs, index + 1, rest);
        return Math.min(p1, p2);
    }

    public int twoCitySchedCost2(int[][] costs) {
        int N = costs.length;
        int M = N >> 1;
        int[][] dp = new int[N + 1][M + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= M; j++) {
                if (N - i == j) {
                    dp[i][j] = costs[i][0] + dp[i + 1][j - 1];
                } else if (j == 0) {
                    dp[i][j] = costs[i][1] + dp[i + 1][j];
                } else {
                    int p1 = costs[i][0] + dp[i + 1][j - 1];
                    int p2 = costs[i][1] + dp[i + 1][j];
                    dp[i][j] = Math.min(p1, p2);
                }
            }
        }
        return dp[0][M];
    }
}
