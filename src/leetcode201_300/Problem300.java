package leetcode201_300;

import java.util.Arrays;

public class Problem300 {
    // 动态规划，O(N^2)
    // dp[i]表示以i结尾最长递增子序列的长度
    /*
     * f(n) = max{f(i)} + 1
     * （1 ≤ i < n - 1，并且 nums[i-1] < nums[n-1]）
     * */
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // O(N*logN)
    public static int lengthOfLIS2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] ends = new int[arr.length];
        // ends[i]表示目前所有长度为i+1的递增子序列的最小结尾
        // 返回ends数组的有效长度+1即为最长递增子序列的长度
        ends[0] = arr[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            max = Math.max(max, l + 1);
        }
        return max;
    }
}
