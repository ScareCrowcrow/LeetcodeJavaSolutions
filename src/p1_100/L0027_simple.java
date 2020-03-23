package p1_100;

// TAG: 快慢指针

public class L0027_simple {
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
