package leetcode901_1000;
import java.util.*;

public class L934_ShortestBridge_medium {
    // https://leetcode.cn/problems/shortest-bridge/?envType=study-plan-v2&envId=graph-theory
    // BFS
    public int shortestBridge(int[][] grid) {
        // BFS 先找到第一个岛  然后BFS找第二个岛，延伸的圈数就是最短距离
        int n = grid.length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        List<int[]> firstLand = new ArrayList<int[]>();
        Queue<int[]> queue = new LinkedList<int[]>();

        // 第一座岛标记为-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        // 第一座岛所有的点
                        firstLand.add(cur);
                        for (int[] dir: directions) {
                            int nextX = cur[0] + dir[0];
                            int nextY = cur[1] + dir[1];
                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                                queue.offer(new int[]{nextX, nextY});
                                grid[nextX][nextY] = -1;
                            }
                        }
                    }
                    for (int[] cell: firstLand) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cur = queue.poll();
                            for (int[] dir: directions) {
                                int nextX = cur[0] + dir[0];
                                int nextY = cur[1] + dir[1];
                                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                                    if (grid[nextX][nextY] == 0) {
                                        queue.offer(new int[]{nextX, nextY});
                                        grid[nextX][nextY] = -1;
                                    } else if (grid[nextX][nextY] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

}
