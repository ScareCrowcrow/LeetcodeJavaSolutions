package leetcode1901_2000;

import java.util.LinkedList;
import java.util.Queue;

public class L1926_NearestExit_medium {
    // https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan-v2&envId=graph-theory
    // BFS
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int cz = queue.size();
            for (int i = 0; i < cz; i++) {
                int[] cur = queue.poll();
                for (int[] dir: directions) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || maze[nextX][nextY] == '+' || visited[nextX][nextY]) {
                        continue;
                    }
                    if (nextX == 0 || nextX == m - 1 || nextY == 0 || nextY == n - 1) {
                        return step;
                    }
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }
}
