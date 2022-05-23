package leetcode501_600;

import java.util.LinkedList;
import java.util.Queue;

public class L542_01Matrix_medium {
    // https://leetcode.cn/problems/01-matrix/
    // BFS
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0], y = j + dirs[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    res[x][y] = res[i][j] + 1;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }
}
