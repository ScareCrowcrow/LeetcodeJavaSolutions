package leetcode1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1192_CriticalConnections_hard {
    // https://leetcode.cn/problems/critical-connections-in-a-network/?envType=study-plan-v2&envId=graph-theory
    // Tarjan强连通分量求解
    // 各强连通分量间的桥边即为最终的解
    // https://www.bilibili.com/video/BV19J411J7AZ?spm_id_from=333.788.player.switch&vd_source=24a079228b82e0061ce93efc20249920&p=5

    int visitOrder = 0;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> list: connections) {
            int u = list.get(0);
            int v = list.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] dfn = new int[n];
        int[] low = new int[n];

        dfs(0, 0, adj, dfn, low);
        return ans;
    }

    private void dfs(int u, int parent, List<Integer>[] adj, int[] dfn, int[] low) {
        low[u] = dfn[u] = visitOrder;
        visitOrder++;
        for (int nei: adj[u]) {
            // 还没访问过的节点，dfs
            if (dfn[nei] == 0) {
                dfs(nei, u, adj, dfn, low);
                low[u] = Math.min(low[u], low[nei]);
                if (low[nei] > dfn[u]) {
                    ans.add(Arrays.asList(u, nei));
                }
            }
            // 如果邻接节点还能回溯到更早被访问到的节点，则更新当前节点的最早访问时间
            else if (dfn[nei] < dfn[u] && nei != parent) {
                low[u] = Math.min(low[u], dfn[nei]);
            }
        }
    }
}
