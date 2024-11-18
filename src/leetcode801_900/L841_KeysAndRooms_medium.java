package leetcode801_900;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L841_KeysAndRooms_medium {
    // https://leetcode.cn/problems/keys-and-rooms/
    private int cnt = 0;
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        return cnt == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        visited[i] = true;
        cnt++;
        for (int j : rooms.get(i)) {
            if (!visited[j]) {
                dfs(rooms, j);
            }
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        // 检测是否连通图
        int n = rooms.size(), num = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            num++;
            for (int neighbor: rooms.get(cur)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return num == n;
    }
}
