package leetcode001_100;

public class L027_RemoveElement_easy {
    // https://leetcode-cn.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) return 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
