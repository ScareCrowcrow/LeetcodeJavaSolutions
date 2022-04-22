package leetcode301_400;

public class Problem396 {
    public int maxRotateFunction(int[] nums) {
        // F(i) - F(i-1) = sumA - nA[n-i]
        int F = 0, sum = 0;
        // F0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        int ans = F;
        for (int i = 1; i < nums.length; i++) {
            F += (sum - nums.length * nums[nums.length - i]);
            ans = Math.max(ans, F);
        }
        return ans;
    }
}
