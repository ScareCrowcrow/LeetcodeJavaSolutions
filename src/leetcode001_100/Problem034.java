package leetcode001_100;

// 二分法：分别查找起点和终点
/*
 * 需要特殊考虑当target==mid时：
 * 1 查找start point时，move left
 * 2 查找end point时，move right
 * */

public class Problem034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
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
        res[0] = st_point;
        res[1] = end_point;
        return res;
    }
}
