package leetcode301_400;

import java.util.HashMap;

public class L325_MaximumSizeSubarraySumEqualsK_medium {
    // https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // preSum 中的值 -> 对应的最小索引
        // 比如 preSum = [2,4,1,3,4]，preSumToIndex[4] = 1
        HashMap<Integer, Integer> preSumToIndex = new HashMap<>();
        int maxLen = 0;
        // 前缀和数组（在这道题中可以优化为一个变量）
        int preSum = 0;
        // base case，这样索引相减的时候可以算出正确的子数组长度
        preSumToIndex.put(0, -1);
        for (int i = 0; i < n; i++) {
            // 计算前缀和，维护 preSum = sum(nums[0..i])
            preSum += nums[i];
            // 确保 preSumToIndex 中记录的索引是第一次出现的位置
            preSumToIndex.putIfAbsent(preSum, i);
            int need = preSum - k;
            if (preSumToIndex.containsKey(need)) {
                int j = preSumToIndex.get(need);
                // nums[j..i] 是和为 k 的子数组
                maxLen = Math.max(maxLen, i - j);
            }
        }
        return maxLen;
    }
}
