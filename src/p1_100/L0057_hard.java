package p1_100;

import java.util.LinkedList;
import java.util.List;

public class L0057_hard {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int m = intervals.length;
        int i = 0;
        int nStart = newInterval[0];
        int nEnd = newInterval[1];
        while (i < m && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        if (i == m){
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        // find insert start
        nStart = Math.min(intervals[i][0], newInterval[0]);
        while (i < m && intervals[i][0] <= newInterval[1]){
            nEnd = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(new int[]{nStart, nEnd});
        while (i < m){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
