package leetcode101_200;

public class Problem198 {
    /* 动态规划
    * 以i结尾的累加和
    * 1.只要i位置的数
    * 1.包含arr[i], 则不包含arr[i-1],dp[i-2]+arr[i]
    * 2.不包含arr[i],dp[i-1]
    * dp[i] = max(dp[i-1], dp[i-2]+arr[i], arr[i])
    */
    public int rob(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        if (N == 1) {
            return arr[0];
        }
        if (N == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], arr[i]), arr[i] + dp[i - 2]);
        }
        return dp[N - 1];
    }
}
