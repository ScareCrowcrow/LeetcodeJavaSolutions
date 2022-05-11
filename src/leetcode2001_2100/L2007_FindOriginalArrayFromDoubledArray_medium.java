package leetcode2001_2100;

import java.util.*;

public class L2007_FindOriginalArrayFromDoubledArray_medium {
    // https://leetcode.cn/problems/find-original-array-from-doubled-array/
    public static int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length == 0) {
            return changed;
        }
        Arrays.sort(changed);
        int n = changed.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        if ((changed[n - 1] & 1) != 0) {
            return new int[]{};
        }
        countMap.put(changed[n - 1] >> 1, 1);
        int[] ans = new int[n >> 1];
        int contained = (n >> 1) - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (countMap.containsKey(changed[i])) {
                ans[contained] = changed[i];
                contained--;
                if (countMap.get(changed[i]) == 1) {
                    countMap.remove(changed[i]);
                } else {
                    countMap.put(changed[i], countMap.get(changed[i]) - 1);
                }
            } else {
                if ((changed[i] & 1) != 0) {
                    return new int[]{};
                }
                if (countMap.containsKey(changed[i] >> 1)) {
                    countMap.put(changed[i] >> 1, countMap.get(changed[i] >> 1) + 1);
                } else {
                    countMap.put(changed[i] >> 1, 1);
                }

            }
        }
        if (countMap.size() == 0) {
            return ans;
        } else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 2, 4};
        int[] ans = findOriginalArray(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
