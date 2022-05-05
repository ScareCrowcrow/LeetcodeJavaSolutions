package leetcode701_800;

public class L713_SubarrayProductLessThanK_medium {
    // https://leetcode-cn.com/problems/subarray-product-less-than-k/
    // 滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int n = nums.length;
        int left = 0, right = 0, product = 1;
        int ans = 0;
        while(right < n) {
            int num = nums[right];
            right++;
            product *= num;
            while(product >= k) {
                int d = nums[left];
                left++;
                product /= d;
            }
            ans += right - left;
        }
        return ans;
    }
}
