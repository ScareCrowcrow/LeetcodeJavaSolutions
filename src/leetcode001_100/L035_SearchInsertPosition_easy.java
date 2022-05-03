package leetcode001_100;

public class L035_SearchInsertPosition_easy {
    // https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        // 二分法
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid;
            else if (nums[mid] > target) end = mid;
            else return mid;
        }
        if (nums[end] < target) return end + 1;
        else if (nums[start] >= target) return start;
        else return end;
    }
}
