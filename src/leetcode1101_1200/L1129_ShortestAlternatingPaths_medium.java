package leetcode1101_1200;

import java.util.*;

public class L1129_ShortestAlternatingPaths_medium {
    // https://leetcode.cn/problems/shortest-path-with-alternating-colors/?envType=study-plan-v2&envId=graph-theory
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 用于分别保存红边 蓝边的邻接列表
        // next[0] 存放 红色有向
        // next[1] 存放 蓝色有向
        // 数组2下标标识当前点，对应存放的list是当前点能够到达的点
        List<Integer>[][] next = new ArrayList[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<Integer>();
            }
        }
        for (int[] edge: redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge: blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        // 两种类型的颜色 分别从0到对应下标的最短路径的长度
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        // BFS
        // 存节点编号和节点路径类型
        Queue<int[]> queue = new LinkedList<int[]>();
        // 到达0位置的路径始终为0
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0], type = pair[1];
            //在已知的路线中，当前点node在 1-type（要么是0要么是1）这个颜色下的可达目标，即以当前点为根，对所有下一级可达低点进行广度优先搜索
            for (int neighbor: next[1-type][node]) {
                //1-type这个颜色下到达点y的最短路径已经有值，则不再次计算
                if (dist[1-type][neighbor] != Integer.MAX_VALUE) continue;
                dist[1-type][neighbor] = dist[type][node] + 1;
                queue.offer(new int[]{neighbor, 1 - type});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
