package leetcode501_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem506 {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) return new String[0];
        if(nums.length==1) {
            return new String[]{"Gold Medal"};
        }
        String[] res = new String[nums.length];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i = 0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        // sort由大到小
        for(int i = 0; i<nums.length/2;i++) {
            int temp = nums[nums.length-i-1];
            nums[nums.length-i-1] = nums[i];
            nums[i] = temp;
        }
        if(nums.length==2) {
            res[map.get(nums[0])] = "Gold Medal";
            res[map.get(nums[1])] = "Silver Medal";
            return res;
        }
        res[map.get(nums[0])] = "Gold Medal";
        res[map.get(nums[1])] = "Silver Medal";
        res[map.get(nums[2])] = "Bronze Medal";
        for(int i = 3;i<nums.length;i++) {
            res[map.get(nums[i])] = i+1+"";
        }
        return res;
    }
}
