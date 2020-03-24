package p1_100;

// TAG: 动态规划

public class L0070_simple {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int cur = 2;
        int prev = 1;
        // f(n) = f(n-1) + f(n-2)
        for (int i = 3; i <= n; i++){
            cur = cur + prev;
            prev = cur - prev;
        }
        return cur;
    }
}
