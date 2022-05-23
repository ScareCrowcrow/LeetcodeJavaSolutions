package leetcode501_600;

import java.util.Arrays;

public class L561_ArrayPartitionI_easy {
    // https://leetcode.cn/problems/array-partition-i/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (idx % 2 == 0) res += nums[idx];
        }
        return res;
    }
}
