package leetcode3201_3300;
import java.util.*;

public class L3243_ShortestDistanceAfterQueries_medium {
    // https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/?envType=daily-question
    // BFS
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i+1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            adj.get(queries[i][0]).add(queries[i][1]);
            ans[i] = bfs(n, adj);
        }
        return ans;
    }

    private int bfs(int n, List<List<Integer>> adj) {
        // 0点到每一个点的距离
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        // while (!queue.isEmpty()) {
        //     int x = queue.poll();
        //     // step++;
        //     for (int nei: adj.get(x)) {
        //         // 已经访问过了，不走回头路
        //         if (dist[nei] >= 0) continue;
        //         queue.offer(nei);
        //         dist[nei] = dist[x] + 1;
        //     }
        // }
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int cur = queue.poll();
                for (int nei: adj.get(cur)) {
                    if (dist[nei] >= 0) continue;
                    queue.offer(nei);
                    dist[nei] = step;
                }
            }
        }
        return dist[n - 1];
    }
}
