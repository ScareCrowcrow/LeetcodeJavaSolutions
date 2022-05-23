package leetcode001_100;

public class L080_RemoveDuplicatesFromSortedArrayII_medium {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 3) return nums.length;
        int loc = 2;
        for (int idx = 2; idx < nums.length; idx++){
            if (!(nums[loc-1] == nums[loc-2] && nums[loc-1] == nums[idx])){
                nums[loc++] = nums[idx];
            }
        }
        return loc;
    }
}
