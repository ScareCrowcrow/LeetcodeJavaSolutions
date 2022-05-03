package leetcode001_100;

// 二分法：分别查找起点和终点
/*
 * 需要特殊考虑当target==mid时：
 * 1 查找start point时，move left
 * 2 查找end point时，move right
 * */

public class L034_FindFirstAndLastPositionOfElementInSortedArray_medium {
    // https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
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

    public static int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int L = lessMostRight(nums, target) + 1;
        if (L == nums.length || nums[L] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { L, lessMostRight(nums, target + 1) };
    }

    // 找到数组arr中小于num最右的数的下标
    public static int lessMostRight(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        int ans = -1;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (arr[M] < num) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return ans;
    }
}
