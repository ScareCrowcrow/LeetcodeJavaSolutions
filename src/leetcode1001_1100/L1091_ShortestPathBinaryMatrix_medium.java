package leetcode1001_1100;
import java.util.*;

public class L1091_ShortestPathBinaryMatrix_medium {
    // https://leetcode.cn/problems/shortest-path-in-binary-matrix/?envType=study-plan-v2&envId=graph-theory
    // BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                if (cur[0] == m -1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir: directions) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        if (nextX == m - 1 && nextY == n - 1) {
                            return step + 1;
                        }
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
