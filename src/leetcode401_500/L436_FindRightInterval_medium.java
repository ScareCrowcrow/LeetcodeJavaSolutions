package leetcode401_500;

import java.util.TreeMap;

public class L436_FindRightInterval_medium {
    // https://leetcode.cn/problems/find-right-interval/
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Integer temp = treeMap.ceilingKey(intervals[i][1]);
            if(temp == null){
                res[i] = -1;
                continue;
            }
            res[i] = treeMap.get(temp);
        }
        return res;
    }
}
