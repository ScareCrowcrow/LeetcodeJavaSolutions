package leetcode801_900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L802_EventualSafeNodes_medium {
    // https://leetcode.cn/problems/find-eventual-safe-states/?envType=study-plan-v2&envId=graph-theory
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 环内节点都不安全
        // 拓扑排序 所有入度为0的节点都是安全无环的
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[n];
        for (int dest = 0; dest < n; dest++) {
            for (int src: graph[dest]) {
                adj.get(src).add(dest);
            }
            inDegree[dest] = graph[dest].length;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor: adj.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
