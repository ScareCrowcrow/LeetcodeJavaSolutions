package leetcode1701_1800;

import java.util.Arrays;

public class Problem1755 {
    // 分治法，数组长度为40，左右最大O(2^20),不超过O(10^8)
    public static int[] l = new int[1 << 20];
    public static int[] r = new int[1 << 20];

    public int minAbsDifference(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return goal;
        }
        // 填充左数的累加和
        int le = process(nums, 0, nums.length >> 1, 0, 0, l);
        // 填充右数的累加和
        int re = process(nums, nums.length >> 1, nums.length, 0, 0, r);
        Arrays.sort(l, 0, le);
        Arrays.sort(r, 0, re--);
        int ans = Math.abs(goal);
        // 左右拼接
        for (int i = 0; i < le; i++) {
            int rest = goal - l[i];
            while (re > 0 && Math.abs(rest - r[re - 1]) <= Math.abs(rest - r[re])) {
                re--;
            }
            ans = Math.min(ans, Math.abs(rest - r[re]));
        }
        return ans;
    }

    public int process(int[] nums, int index, int end, int sum, int fill, int[] arr) {
        if (index == end) {
            arr[fill++] = sum;
        } else {
            fill = process(nums, index + 1, end, sum, fill, arr);
            fill = process(nums, index + 1, end, sum + nums[index], fill, arr);
        }
        return fill;
    }
}
