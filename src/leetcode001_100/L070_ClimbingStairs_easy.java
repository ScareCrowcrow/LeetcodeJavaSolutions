package leetcode001_100;

public class L070_ClimbingStairs_easy {
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
