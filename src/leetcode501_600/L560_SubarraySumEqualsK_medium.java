package leetcode501_600;

import java.util.HashMap;

public class L560_SubarraySumEqualsK_medium {
    // https://leetcode.cn/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSumMap.containsKey(sum - k)) {
                ans += preSumMap.get(sum - k);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
