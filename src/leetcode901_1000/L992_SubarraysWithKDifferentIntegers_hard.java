package leetcode901_1000;

import java.util.HashMap;

public class L992_SubarraysWithKDifferentIntegers_hard {
    // https://leetcode.cn/problems/subarrays-with-k-different-integers/
    // 题目规定，nums中的数字，不会超过nums数组的长度
    public static int subarraysWithKDistinct1(int[] nums, int k) {
        int n = nums.length;
        // k-1种数的窗口词频统计
        int[] lessCounts = new int[n + 1];
        // k种数的窗口词频统计
        int[] equalCounts = new int[n + 1];
        // k-1种数的左边界
        int lessLeft = 0;
        // k种数的左边界
        int equalLeft = 0;
        int lessKinds = 0;
        int equalKinds = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            // 当前刚来到r位置！
            if (lessCounts[nums[r]] == 0) {
                lessKinds++;
            }
            if (equalCounts[nums[r]] == 0) {
                equalKinds++;
            }
            lessCounts[nums[r]]++;
            equalCounts[nums[r]]++;
            while (lessKinds == k) {
                if (lessCounts[nums[lessLeft]] == 1) {
                    lessKinds--;
                }
                lessCounts[nums[lessLeft++]]--;
            }
            while (equalKinds > k) {
                if (equalCounts[nums[equalLeft]] == 1) {
                    equalKinds--;
                }
                equalCounts[nums[equalLeft++]]--;
            }
            ans += lessLeft - equalLeft;
        }
        return ans;
    }

    public static int subarraysWithKDistinct2(int[] arr, int k) {
        return numsMostK(arr, k) - numsMostK(arr, k - 1);
    }

    // 数组arr中收集到数字种类小于等于k种的子数组的个数
    // 滑动窗口
    public static int numsMostK(int[] arr, int k) {
        int i = 0, res = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < arr.length; ++j) {
            if (count.getOrDefault(arr[j], 0) == 0) {
                k--;
            }
            count.put(arr[j], count.getOrDefault(arr[j], 0) + 1);
            while (k < 0) {
                count.put(arr[i], count.get(arr[i]) - 1);
                if (count.get(arr[i]) == 0) {
                    k++;
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
