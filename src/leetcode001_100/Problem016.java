package leetcode001_100;

import java.util.Arrays;

public class Problem016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) return target;
        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int base = 0; base < nums.length - 2; base++){
            // 三指针
            int start = base + 1;
            int end = nums.length - 1;
            while (start < end){
                int newdelta = nums[base] + nums[start] + nums[end] - target;
                if (newdelta == 0) return target;
                if (Math.abs(delta) > Math.abs(newdelta))
                    delta = newdelta;
                if (newdelta < 0) start++;
                else end--;
            }
        }
        return target + delta;
    }
}
