package leetcode501_600;

import java.util.HashSet;

public class L523_ContinuousSubarraySum_medium {
    // https://leetcode.cn/problems/continuous-subarray-sum/
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= nums.length; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;
    }
}
