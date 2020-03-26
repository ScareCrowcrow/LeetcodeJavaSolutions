package InterviewQuestions;

// TAG: 二分法

public class p53_I_simple {
    public int search(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length == 0) return res;
        int st_point = -1, end_point = -1;
        int start = 0, end = nums.length - 1;
        // find the start point
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid;
        }
        if (nums[start] == target) st_point = start;
        else if (nums[end] == target) st_point = end;
        if (st_point == -1) return res;

        start = 0;
        end = nums.length - 1;
        // find the end point
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid;
            else start = mid;
        }
        if (nums[end] == target) end_point = end;
        else if(nums[start] == target) end_point = start;
        res = end_point - st_point + 1;
        return res;
    }
}
