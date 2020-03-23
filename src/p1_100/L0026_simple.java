package p1_100;

// TAG: 快慢指针
public class L0026_simple {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
