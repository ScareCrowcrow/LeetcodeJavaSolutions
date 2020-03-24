package p1_100;

public class L0055_medium {
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
