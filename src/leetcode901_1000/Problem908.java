package leetcode901_1000;

public class Problem908 {
    // https://leetcode-cn.com/problems/smallest-range-i/
    public int smallestRangeI(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for(int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
