package leetcode101_200;

import java.util.Arrays;

public class Problem154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        if (nums[end] > nums[0]) {
            return nums[0];
        }
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid+1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if (nums[start] >= nums[0] && nums[start] <= nums[nums.length-1]) return nums[start];
        if (nums[end] >= nums[0] && nums[end] <= nums[nums.length-1]) return nums[end];
        return -1;
    }
}
