package leetcode801_900;

public class L875_KokoEatingBananas_medium {
    // https://leetcode.cn/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        // 单调性，时间久吃得慢。
        // 二分法解决，找出最耗时的
        int L = 1;
        int R = 0;
        for (int pile: piles){
            R = Math.max(R, pile);
        }
        int ans = 0;
        int M = 0;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (hours(piles, M) <= h) {
                ans = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return ans;
    }

    public static int hours(int[] piles, int speed) {
        int ans = 0;
        int offset = speed - 1;
        for (int pile: piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }
}
