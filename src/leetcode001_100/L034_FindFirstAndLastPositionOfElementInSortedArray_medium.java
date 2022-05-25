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
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    public int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩左侧边界
                left = mid + 1;
            }
        }
        // 检查出界情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
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
