package leetcode1501_1600;

public class L1510_StoneGameIV_hard {
    // https://leetcode-cn.com/problems/stone-game-iv/
    // 当前的！先手，会不会赢
    // 打表，不能发现规律
    public static boolean winnerSquareGame1(int n) {
        if (n == 0) {
            return false;
        }
        // 当前的先手，会尝试所有的情况，1，4，9，16，25，36....
        for (int i = 1; i * i <= n; i++) {
            // 当前的先手，决定拿走 i * i 这个平方数
            // 它的对手会不会赢？ winnerSquareGame1(n - i * i)
            if (!winnerSquareGame1(n - i * i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean winnerSquareGame2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = -1;
        return process2(n, dp);
    }

    public static boolean process2(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n] == 1 ? true : false;
        }
        boolean ans = false;
        for (int i = 1; i * i <= n; i++) {
            if (!process2(n - i * i, dp)) {
                ans = true;
                break;
            }
        }
        dp[n] = ans ? 1 : -1;
        return ans;
    }

    public static boolean winnerSquareGame3(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
