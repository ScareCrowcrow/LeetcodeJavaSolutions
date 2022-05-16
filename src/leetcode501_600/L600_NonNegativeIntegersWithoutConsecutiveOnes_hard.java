package leetcode501_600;

public class L600_NonNegativeIntegersWithoutConsecutiveOnes_hard {
    // https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
    public static int findIntegers(int n) {
        int i = 31;
        // 找最高位
        for (; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                break;
            }
        }
        // for循环出来之后，i表示，n最高位的1，在哪？
        // 从这个位置，往右边低位上走！
        int[][][] dp = new int[2][2][i + 1];
        return f(0, 0, i, n, dp);
    }


    public static int f(int pre, int alreadyLess, int index, int num, int[][][] dp) {
        if (index == -1) {
            return 1;
        }
        if (dp[pre][alreadyLess][index] != 0) {
            return dp[pre][alreadyLess][index];
        }
        int ans = 0;
        if (pre == 1) {
            ans = f(0, Math.max(alreadyLess, (num & (1 << index)) != 0 ? 1 : 0), index - 1, num, dp);
        } else {
            if ((num & (1 << index)) == 0 && alreadyLess == 0) {
                ans = f(0, alreadyLess, index - 1, num, dp);
            } else {
                ans = f(1, alreadyLess, index - 1, num, dp)
                        + f(0, Math.max(alreadyLess, (num & (1 << index)) != 0 ? 1 : 0), index - 1, num, dp);
            }
        }
        dp[pre][alreadyLess][index] = ans;
        return ans;
    }
}
