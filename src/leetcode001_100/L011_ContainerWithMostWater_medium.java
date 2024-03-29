package leetcode001_100;

public class L011_ContainerWithMostWater_medium {
    // https://leetcode.cn/problems/container-with-most-water/
    // 双指针 LR谁小结算谁
    public static int maxArea(int[] h) {
        int max = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if (h[l] > h[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
