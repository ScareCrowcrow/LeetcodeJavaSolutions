package leetcode401_500;

public class L441_ArrangingCoins_easy {
    // https://leetcode.cn/problems/arranging-coins/
    public int arrangeCoins(int n) {
        // 前k阶台阶所需硬币数为k*(k+1)/2
        int left = 0, right = n;
        long all = (long) n;
        while(left <= right) {
            long mid = left + ((right - left) >> 1);
            if(mid * mid + mid == 2 * all) {
                return (int) mid;
            }
            if(mid * mid + mid < 2 * all) {
                left = (int) mid + 1;
            } else if(mid * mid + mid > 2 * all) {
                right = (int) mid - 1;
            }
        }
        return left - 1;
    }
}
