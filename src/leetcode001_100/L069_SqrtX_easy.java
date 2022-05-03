package leetcode001_100;

public class L069_SqrtX_easy {
    // https://leetcode-cn.com/problems/sqrtx/
    // x一定非负，输入可以保证
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 3) {
            return 1;
        }
        // x >= 3
        long ans = 1;
        long L = 1;
        long R = x;
        long M = 0;
        while (L <= R) {
            M = (L + R) / 2;
            if (M * M <= x) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return (int) ans;
    }

    public int mySqrt2(int x) {
        // 规律:等差数列
        int cur = 0;
        int res = 0;
        int add = 1;
        while (cur <= x){
            if (Integer.MAX_VALUE - cur < add) return res;
            cur += add;
            res++;
            add += 2;
        }
        return res - 1;
    }
}
