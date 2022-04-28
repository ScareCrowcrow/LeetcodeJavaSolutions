package leetcode001_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 传统的解题思路是两遍循环，时间复杂度为O(n^2),空间复杂度为O(1)
 *
 * 改进的方法：建立一个value->index的映射，遍历一遍数组，遍历的过程中判断target-num是否已存在于map中，
 * 时间复杂度为O(n),空间复杂度为O(n)
 * */
public class Problem001 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length <= 1) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
