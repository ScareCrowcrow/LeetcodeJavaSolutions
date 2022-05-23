package leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L018_FourSum_medium {
    // https://leetcode.cn/problems/4sum/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            // 去重
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for(int j = i + 1; j < n; j++) {
                // 去重
                if(j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target) {
                        right--;
                    }else if(sum < target) {
                        left++;
                    }else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重
                        while(left < right && nums[right] == nums[right-1]) right--;
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
