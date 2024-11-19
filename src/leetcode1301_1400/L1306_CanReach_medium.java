package leetcode1301_1400;
import java.util.*;

public class L1306_CanReach_medium {
    // https://leetcode.cn/problems/jump-game-iii/?envType=study-plan-v2
    // BFS
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int curIdx = q.poll();
                int next1Idx = curIdx + arr[curIdx];
                if (next1Idx >= 0 && next1Idx < n && visited[next1Idx] == false) {
                    if (arr[next1Idx] == 0) return true;
                    q.offer(next1Idx);
                    visited[next1Idx] = true;
                }
                int next2Idx = curIdx - arr[curIdx];
                if (next2Idx >= 0 && next2Idx < n && visited[next2Idx] == false) {
                    if (arr[next2Idx] == 0) return true;
                    q.offer(next2Idx);
                    visited[next2Idx] = true;
                }
            }
        }
        return false;
    }
}
