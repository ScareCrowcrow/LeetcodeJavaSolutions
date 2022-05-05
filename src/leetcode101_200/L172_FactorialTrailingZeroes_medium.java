package leetcode101_200;

public class L172_FactorialTrailingZeroes_medium {
    // https://leetcode-cn.com/problems/factorial-trailing-zeroes/
    // 计算5因子的个数
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    public int trailingZeroes2(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
}
