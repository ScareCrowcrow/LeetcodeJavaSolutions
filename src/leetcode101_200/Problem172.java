package leetcode101_200;

public class Problem172 {
    public int trailingZeroes(int n) {
        // 计算5因子的个数
        if(n < 0) {
            return 0;
        }
        int res = 0;
        while(n != 0) {
            res += n/5;
            n /= 5;
        }
        return res;
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
