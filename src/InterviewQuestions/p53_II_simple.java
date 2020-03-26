package InterviewQuestions;

// TAG: 二分法

public class p53_II_simple {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0 || nums[0] != 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start] == start ? nums[start] + 1 : nums[start] - 1;
    }
}
