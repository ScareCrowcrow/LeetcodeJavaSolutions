package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class p17_10_simple {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > len/2) return nums[i];
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > len / 2) return entry.getKey();
        }
        return -1;
    }
}
