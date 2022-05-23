package leetcode601_700;

public class L643_MaximumAverageSubarrayI_easy {
    // https://leetcode.cn/problems/maximum-average-subarray-i/
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        // 由于题目限制了 k <= len，因此不用做特判
        int windowSum = 0;
        // 第 1 步：先求出第 1 个窗口的和
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // 第 2 步：通过遍历求出除了第 1 个窗口的和
        int res = windowSum;
        // 循环不变量定义：[left..right) 是长度为 k 的窗口
        for (int right = k; right < len; right++) {
            // 加上一个数再减去一个数
            windowSum = windowSum + nums[right] - nums[right - k];
            res = Math.max(res, windowSum);
        }
        return (double) res / k;
    }
}
