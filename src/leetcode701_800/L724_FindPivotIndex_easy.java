package leetcode701_800;

public class L724_FindPivotIndex_easy {
    // https://leetcode.cn/problems/find-pivot-index/
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        if (preSum[n - 1] - preSum[0] == 0) return 0;
        for (int i = 1; i < n; i++) {
            if (preSum[i - 1] == preSum[n - 1] - preSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
