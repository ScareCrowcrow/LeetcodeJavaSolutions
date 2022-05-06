package leetcode201_300;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L253_MeetingRoomsII_medium {
    // https://leetcode-cn.com/problems/meeting-rooms-ii/
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        q.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(q.peek() <= intervals[i][0]){
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}
