package leetcode001_100;

public class L050_PowXN_medium {
    // https://leetcode-cn.com/problems/powx-n/
    public static int pow(int a, int n) {
        int ans = 1;
        int t = a;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans *= t;
            }
            t *= t;
            n >>= 1;
        }
        return ans;
    }

    // x的n次方，n可能是负数
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        int pow = Math.abs(n == Integer.MIN_VALUE ? n + 1 : n);
        double t = x;
        double ans = 1D;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= t;
            }
            pow >>= 1;
            t = t * t;
        }
        if (n == Integer.MIN_VALUE) {
            ans *= x;
        }
        return n < 0 ? (1D / ans) : ans;
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        // 如果是系统最小，则取系统最大
        int pow = Math.abs(n == Integer.MIN_VALUE ? n + 1: n);
        double t = x;
        double ans = 1D;
        while (pow != 0) {
            if((pow & 1) != 0) {
                ans *= t;
            }
            pow >>= 1;
            t = t * t;
        }
        // x的系统最小次方 = 1/(x的系统最小绝对值次方) x的系统最大次方 * x = x的系统最小绝对值次方
        if (n == Integer.MIN_VALUE) {
            ans *= x;
        }
        return n < 0 ? (1D / ans) : ans;
    }
}
