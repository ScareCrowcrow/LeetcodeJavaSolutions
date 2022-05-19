package leetcode401_500;

import java.util.Arrays;

public class L462_MinimumMovesToEqualArrayElementsII_medium {
    // https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ans = 0;
        while(left < right) {
            ans += nums[right--] - nums[left++];
        }
        return ans;

    }
}
