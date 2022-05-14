package leetcode601_700;

import java.util.Arrays;

public class L611_ValidTriangleNumber_medium {
    // https://leetcode.cn/problems/valid-triangle-number/
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;

        // 先固定最长的一条边，然后利用双指针
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
