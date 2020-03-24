package p1_100;

// TAG：贪心

public class L0053_simple {
    public int maxSubArray(int[] nums) {
        int maxToCur = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxToCur = Math.max(maxToCur + nums[i], nums[i]);
            sum = Math.max(sum, maxToCur);
        }
        return sum;
    }
}
