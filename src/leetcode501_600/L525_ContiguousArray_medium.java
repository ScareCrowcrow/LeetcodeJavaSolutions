package leetcode501_600;

import java.util.HashMap;
import java.util.Map;

public class L525_ContiguousArray_medium {
    // https://leetcode.cn/problems/contiguous-array/
    // 将原数组的0全部变为-1 则问题等价于“元素值总和为0的连续数组”
    // 接着遍历数组 记录当前的前缀和的值 若该前缀和的值已出现过
    // 则说明标记中的下标到当前扫描的下标的这段数组的总和值是为0的
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0, length = nums.length, sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += (nums[i] == 1) ? 1 : -1; // 更新当前的前缀和
            map.putIfAbsent(sum, i); // 要保留前缀和为 sum 出现最早的位置
            int tmp = i - map.getOrDefault(sum, Integer.MAX_VALUE);
            result = Math.max(result, tmp); // 更新数组长度
        }
        return result;
    }
}
