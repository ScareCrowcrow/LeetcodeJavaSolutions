package leetcode301_400;

public class L303_RangeSumQueryImmutable_easy {
    // https://leetcode.cn/problems/range-sum-query-immutable/
    class NumArray {
        // 前缀和数组
        private int[] preSum;

        public NumArray(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
