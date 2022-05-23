package leetcode001_100;

public class L055_JumpGame_medium {
    // https://leetcode.cn/problems/jump-game/
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int reach = 0, i = 0;
        for (i = 0; i < nums.length && i <= reach; i++){
            reach = Math.max(nums[i] + i, reach);
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
