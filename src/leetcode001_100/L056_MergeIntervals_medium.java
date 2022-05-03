package leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L056_MergeIntervals_medium {
    // https://leetcode-cn.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        // 将所有区间按起始时间的先后顺序排序
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] previous = null;
        List<int[]> result = new ArrayList<>();

        for(int[] current: intervals){
            // 如果这是第一个区间，或者当前区间和第一个区间没有重叠，那么将当前区间加入到结果中
            if(previous == null || current[0] > previous[1]){
                previous = current;
                result.add(current);
            }else{
                // 否则，两个区间发生了重叠，更新前一个区间的结束时间
                previous[1] = Math.max(previous[1], current[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int s = intervals[0][0];
        int e = intervals[0][1];
        int size = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > e) {
                intervals[size][0] = s;
                intervals[size++][1] = e;
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                e = Math.max(e, intervals[i][1]);
            }
        }
        intervals[size][0] = s;
        intervals[size++][1] = e;
        return Arrays.copyOf(intervals, size);
    }
}
