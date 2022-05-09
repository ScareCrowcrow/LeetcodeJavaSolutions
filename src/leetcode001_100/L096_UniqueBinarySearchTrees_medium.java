package leetcode001_100;

public class L096_UniqueBinarySearchTrees_medium {
    // https://leetcode.cn/problems/unique-binary-search-trees/
    // 卡特兰数
    public int numTrees1(int N) {
        if (N < 0) {
            return 0;
        }
        if (N < 2) {
            return 1;
        }
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int leftSize = 0; leftSize < i; leftSize++) {
                dp[i] += dp[leftSize] * dp[i - 1 - leftSize];
            }
        }
        return dp[N];
    }
}
