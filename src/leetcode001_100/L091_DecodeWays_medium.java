package leetcode001_100;
/*
* 定义dp[i]是nums前i个字符可以得到的解码种数，假设之前的字符串是abcx，现在新加入了y，则有以下5种情况：

    1、如果x=='0'，且y=='0'，无法解码，返回0；
    2、如果只有x=='0'，则y只能单独放在最后，不能与x合并(不能以0开头)，此时有：dp[i] = dp[i-1]
    3、如果只有y=='0'，则y不能单独放置，必须与x合并，并且如果合并结果大于26，返回0，否则有：dp[i] = dp[i-2]
    4、如果 xy<=26: 则y可以“单独”放在abcx的每个解码结果之后，并且如果abcx以x单独结尾，此时可以合并xy作为结尾，
        而这种解码种数就是abc的解码结果，此时有：dp[i+1] = dp[i] + dp[i-1]
    5、如果 xy>26: 此时x又不能与y合并，y只能单独放在dp[i]的每一种情况的最后，此时有：dp[i+1] = dp[i]
*
*
* */

public class L091_DecodeWays_medium {
    // https://leetcode-cn.com/problems/decode-ways/
    // 动态规划：从左到右的尝试模型
    public static int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0);
    }

    // 潜台词：str[0...index-1]已经转化完了，不用操心了
    // str[index....] 能转出多少有效的，返回方法数
    public static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int ways = process(str, index + 1);
        if (index + 1 == str.length) {
            return ways;
        }
        int num = (str[index] - '0') * 10 + str[index + 1] - '0';
        if (num < 27) {
            ways += process(str, index + 2);
        }
        return ways;
    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        // dp[i] -> process(str, index)返回值 index 0 ~ N
        int[] dp = new int[N + 1];
        dp[N] = 1;

        // dp依次填好 dp[i] dp[i+1] dp[i+2]
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 == str.length) {
                    continue;
                }
                int num = (str[i] - '0') * 10 + str[i + 1] - '0';
                if (num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else if (str[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            } else if (str[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
