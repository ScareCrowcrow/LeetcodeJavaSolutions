package leetcode201_300;

import java.util.HashMap;

public class L219_ContainsDuplicateII_easy {
    // https://leetcode.cn/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = map.get(nums[i]);
            if(key != null && k >= Math.abs(i - key)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
