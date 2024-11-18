package leetcode1301_1400;

import java.util.*;

public class L1376_NumOfMinutes_medium {
    // https://leetcode.cn/problems/time-needed-to-inform-all-employees/?envType=study-plan-v2&envId=graph-theory
    // BFS
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(manager[i], new ArrayList<Integer>());
            adj.get(manager[i]).add(i);
        }
        // node time
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{headID, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int managerId = arr[0], time = arr[1];
            // 当前节点没有下属
            if (!adj.containsKey(managerId)) {
                ans = Math.max(ans, time);
            } else {
                for (int neighbor: adj.get(managerId)) {
                    queue.offer(new int[]{neighbor, time + informTime[managerId]});
                }
            }
        }
        return ans;
    }

    // DFS
    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(manager[i], new ArrayList<Integer>());
            adj.get(manager[i]).add(i);
        }
        return dfs(headID, informTime, adj);
    }

    public int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> adj) {
        int ans = 0;
        for (int neighbor: adj.getOrDefault(cur, new ArrayList<Integer>())) {
            ans = Math.max(ans, dfs(neighbor, informTime, adj));
        }
        return informTime[cur] + ans;
    }
}
