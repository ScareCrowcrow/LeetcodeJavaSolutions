package leetcode1401_1500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L1466_MinReorder_medium {
    // https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=graph-theory
    // DFS
    private int res = 0;
    // 假设是无向图，统计反向边的数量
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        // 实例化每个结点的邻接列表
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] con: connections) {
            // con[0]指向con[1], 存正数
            adj.get(con[0]).add(con[1]);
            // con[1]指向con[0], 存负数
            adj.get(con[1]).add(-con[0]);
        }
        dfs(0, -1, adj);
        return res;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj) {
        for (int neighbor: adj.get(node)) {
            int nei = Math.abs(neighbor);
            if (nei != parent) {
                // 需要反向的边
                if (neighbor > 0) res++;
                dfs(nei, node, adj);
            }
        }
    }

    // BFS
    public int minReorder2(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        // 实例化每个结点的邻接列表
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] con: connections) {
            // con[0]指向con[1], 存正数
            adj.get(con[0]).add(con[1]);
            // con[1]指向con[0], 存负数
            adj.get(con[1]).add(-con[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor: adj.get(node)) {
                int nei = Math.abs(neighbor);
                if (visited[nei]) continue;
                visited[nei] = true;
                queue.offer(nei);
                if (neighbor > 0) ans++;
            }
        }
        return ans;
    }
}
