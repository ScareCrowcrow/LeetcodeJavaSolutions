package leetcode101_200;

public class L153_FindMinimumInRotatedSortedArray_medium {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
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
        return -1;
    }
}
