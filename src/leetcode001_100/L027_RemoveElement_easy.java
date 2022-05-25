package leetcode001_100;

public class L027_RemoveElement_easy {
    // https://leetcode.cn/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) return 0;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
