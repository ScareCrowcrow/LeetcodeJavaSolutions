package leetcode1001_1100;

import java.util.HashMap;
import java.util.Map;

public class L1027_LongestArithmeticSubsequence_medium {
    // https://leetcode.cn/problems/longest-arithmetic-subsequence/
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int j = 0 ; j < n ; j++){
            for(int k = j + 1 ; k < n ; k++){
                int target = 2 * nums[j] - nums[k];
                if(map.containsKey(target))
                    dp[j][k] = dp[map.get(target)][j] + 1;
                ans = Math.max(ans , dp[j][k]);
            }
            map.put(nums[j], j);
        }

        return ans + 2;
    }
}
