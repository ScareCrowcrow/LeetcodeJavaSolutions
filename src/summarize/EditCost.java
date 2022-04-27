package summarize;

public class EditCost {
    // ic insert cost
    // dc delete cost
    // rc replace cost
    // dp 样本对应模型
    // dp[i][j] 表示str1[0...i]变成str2[0...j]的最小代价
    /*
    * 情况1：dp[i-1][j] + dc, str1前i-1个字符变成str2前j个字符，删除str1的第i个字符
    * 情况2：dp[i][j-1] + ic, str1前i个字符变成str2前j-1个字符，尾部插入一个字符
    * 情况3：str1[i-1] == str2[j-1], dp[i-1][j-1]
    * 情况4：str1[i-1] != str2[j-1], dp[i-1][j-1] + rc
    * */
    public static int minCost1(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = str1.length + 1;
        int M = str2.length + 1;
        int[][] dp = new int[N][M];
        // dp[0][0] = 0
        for (int i = 1; i < N; i++) {
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < M; j++) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + (str1[i - 1] == str2[j - 1] ? 0 : rc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[N - 1][M - 1];
    }

    public static int minCost2(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
        char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
        if (chs1.length < chs2.length) {
            int tmp = ic;
            ic = dc;
            dc = tmp;
        }
        int[] dp = new int[shorts.length + 1];
        for (int i = 1; i <= shorts.length; i++) {
            dp[i] = ic * i;
        }
        for (int i = 1; i <= longs.length; i++) {
            int pre = dp[0];
            dp[0] = dc * i;
            for (int j = 1; j <= shorts.length; j++) {
                int tmp = dp[j];
                if (longs[i - 1] == shorts[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = pre + rc;
                }
                dp[j] = Math.min(dp[j], dp[j - 1] + ic);
                dp[j] = Math.min(dp[j], tmp + dc);
                pre = tmp;
            }
        }
        return dp[shorts.length];
    }
}
