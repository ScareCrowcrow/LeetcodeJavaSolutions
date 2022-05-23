package leetcode1901_2000;

public class L1991_FindTheMiddleIndexInArray_easy {
    // https://leetcode.cn/problems/find-the-middle-index-in-array/
    public int findMiddleIndex(int[] nums) {
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
