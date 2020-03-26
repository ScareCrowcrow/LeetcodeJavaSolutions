package InterviewQuestions;

import java.util.Arrays;

public class p61_simple {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int zeroCount = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++){
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (nums[i] == nums[i+1]) return false;
            zeroCount -= (nums[i+1]-nums[i]-1);
        }
        return zeroCount>=0;
    }
}
