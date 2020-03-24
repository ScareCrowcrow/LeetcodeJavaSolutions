package p1_100;

/*
* 思路：1、将所有非正数标记为Integer.MAX_VALUE
*      2、reverse对应位
*      3、遍历:第一个负数
*
* */

public class L0041_hard {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if (num <= nums.length){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
