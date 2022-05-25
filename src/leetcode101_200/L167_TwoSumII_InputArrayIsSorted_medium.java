package leetcode101_200;

import java.util.HashMap;
import java.util.Map;

public class L167_TwoSumII_InputArrayIsSorted_medium {
    // https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left++;
            }else if(sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = {-1, -1};
        if (numbers == null || numbers.length <= 1) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])){
                res[0] = map.get(target-numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }else{
                map.put(numbers[i], i);
            }
        }
        return res;
    }
}
