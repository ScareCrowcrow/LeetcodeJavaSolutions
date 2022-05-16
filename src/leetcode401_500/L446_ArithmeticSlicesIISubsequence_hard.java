package leetcode401_500;

import java.util.ArrayList;
import java.util.HashMap;

public class L446_ArithmeticSlicesIISubsequence_hard {
    // https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
    public int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        int all = 0;
        // 以i结尾，key为差值，value为序列个数
        ArrayList<HashMap<Integer, Integer>> maps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            maps.add(new HashMap<>());
            // 以i结尾，遍历j...i所有的可能
            for (int j = i - 1; j >= 0; j--) {
                long diff = (long) nums[i] - (long) nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int dif = (int) diff;
                int count = maps.get(j).getOrDefault(dif, 0);
                all += count;
                maps.get(i).put(dif, maps.get(i).getOrDefault(dif, 0) + count + 1);
            }
        }
        return all;
    }
}
