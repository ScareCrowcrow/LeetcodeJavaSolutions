package leetcode101_200;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {
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
        return 0;
    }

    public int majorityElement2(int[] arr) {
        // 一次删除2个不同值的元素，如果不剩元素，就无水王数
        // 如果还剩元素，统计剩余元素的个数，如果大于N/2一定是超级水王数
        // 临时变量候选cand，血量HP。血量为0时，表示无候选
        // 规则1.无候选，当前数为候选，血量=1
        // 规则2.有候选，如果当前数!=候选，血量--；如果当前数==候选，血量++
        int cand = 0;
        int HP = 0;
        for (int i = 0; i < arr.length; i++) {
            if (HP == 0) {
                cand = arr[i];
                HP = 1;
            } else if (arr[i] == cand) {
                HP++;
            } else {
                HP--;
            }
        }
        if(HP == 0) {
            return -1;
        }
        HP = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                HP++;
            }
        }
        if (HP > arr.length / 2) {
            return cand;
        } else {
            return -1;
        }
    }
}
