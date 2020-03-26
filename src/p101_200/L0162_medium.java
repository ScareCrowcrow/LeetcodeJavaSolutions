package p101_200;

// TAG: 二分法

public class L0162_medium {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) /2;
            if (nums[mid] > nums[mid + 1]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
