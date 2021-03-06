package p101_200;

import java.util.HashMap;
import java.util.Map;

public class L0167_simple {
    public int[] twoSum(int[] numbers, int target) {
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
