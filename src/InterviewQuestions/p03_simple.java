package InterviewQuestions;

import java.util.HashSet;

public class p03_simple {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
