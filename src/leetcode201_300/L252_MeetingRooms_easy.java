package leetcode201_300;

import java.util.Arrays;

public class L252_MeetingRooms_easy {
    // https://leetcode.cn/problems/meeting-rooms/
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < intervals.length - 1; i++) {
            int[] cur = intervals[i], next = intervals[i + 1];
            if(cur[1] > next[0]) {
                return false;
            }
        }
        return true;
    }
}
