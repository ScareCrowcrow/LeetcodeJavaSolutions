package p1_100;

// 二分法

public class L0033_medium {
    public int search(int[] nums, int target) {
        if (nums ==  null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && nums[mid] >= target) end = mid;
                else start = mid;
            }else if (nums[mid] < nums[end]){
                if (nums[end] >= target && nums[mid] <= target) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
