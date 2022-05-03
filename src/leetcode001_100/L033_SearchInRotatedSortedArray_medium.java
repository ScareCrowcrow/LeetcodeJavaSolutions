package leetcode001_100;

public class L033_SearchInRotatedSortedArray_medium {
    // https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
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

    public static int search2(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L <= R) {
            // M = L + ((R - L) >> 1)
            M = (L + R) / 2;
            if (arr[M] == num) {
                return M;
            }
            // arr[M] != num
            // [L] == [M] == [R] != num 无法二分
            if (arr[L] == arr[M] && arr[M] == arr[R]) {
                while (L != M && arr[L] == arr[M]) {
                    L++;
                }
                // 1) L == M L...M 一路都相等
                // 2) 从L到M终于找到了一个不等的位置
                if (L == M) { // L...M 一路都相等
                    L = M + 1;
                    continue;
                }
            }
            // arr[M] != num
            // [L] [M] [R] 不都一样的情况, 如何二分的逻辑
            if (arr[L] != arr[M]) {
                if (arr[M] > arr[L]) { // L...M 一定有序
                    if (num >= arr[L] && num < arr[M]) { //  3  [L] == 1    [M]   = 5   L...M - 1
                        R = M - 1;
                    } else { // 9    [L] == 2    [M]   =  7   M... R
                        L = M + 1;
                    }
                } else { // [L] > [M]    L....M  存在断点
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            } else { /// [L] [M] [R] 不都一样，  [L] === [M] -> [M]!=[R]
                if (arr[M] < arr[R]) {
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if (num >= arr[L] && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }
}
