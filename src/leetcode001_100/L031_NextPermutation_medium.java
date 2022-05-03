package leetcode001_100;

import java.util.Arrays;

public class L031_NextPermutation_medium {
    // https://leetcode-cn.com/problems/next-permutation/
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int replace = nums.length - 2;
        while (replace >= 0){
            // find replace index
            if (nums[replace] < nums[replace+1]) break;
            replace--;
        }
        // nums is sorted
        if (replace < 0){
            Arrays.sort(nums);
            return;
        }

        // replace curr number with closest larger number
        int lgrIdx = replace + 1;
        while (lgrIdx < nums.length && nums[lgrIdx] > nums[replace]){
            lgrIdx++;
        }
        int tmp = nums[replace];
        nums[replace] = nums[lgrIdx-1];
        nums[lgrIdx-1] = tmp;
        Arrays.sort(nums, replace+1, nums.length);
    }
}
