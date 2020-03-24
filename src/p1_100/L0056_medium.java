package p1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0056_medium {
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
}
