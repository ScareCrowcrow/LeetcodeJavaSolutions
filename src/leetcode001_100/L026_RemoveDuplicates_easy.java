package leetcode001_100;

public class L026_RemoveDuplicates_easy {
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != nums[slow]) {
                slow++;
                // 维护nums[0...slow]无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
