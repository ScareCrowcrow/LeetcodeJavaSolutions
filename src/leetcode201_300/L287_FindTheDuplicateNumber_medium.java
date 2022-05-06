package leetcode201_300;

public class L287_FindTheDuplicateNumber_medium {
    // https://leetcode-cn.com/problems/find-the-duplicate-number/
    // 单链表首个入环节点查找
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
