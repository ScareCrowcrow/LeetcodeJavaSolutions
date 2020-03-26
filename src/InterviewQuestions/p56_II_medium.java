package InterviewQuestions;

import java.util.HashMap;
import java.util.HashSet;

public class p56_II_medium {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) != 3){
                return nums[i];
            }
        }
        return 0;
    }
}
