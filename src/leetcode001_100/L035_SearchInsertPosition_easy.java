package leetcode001_100;

public class L035_SearchInsertPosition_easy {
    // https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int L = 0;
        int R = nums.length - 1;
        int ans = nums.length;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (nums[M] >= target) {
                ans = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return ans;
    }
}
