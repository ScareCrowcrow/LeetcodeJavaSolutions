package leetcode801_900;
import java.util.*;

public class L864_ShortestPathAllKeys_hard {
    // https://leetcode.cn/problems/shortest-path-to-get-all-keys/?envType=study-plan-v2&envId=graph-theory
    public int shortestPathAllKeys(String[] grid) {
        // mask的第i位为1表示有了第i把钥匙
        int m = grid.length;
        int n = grid[0].length();
        int startX = 0, startY = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // {key: 第几把}
        Map<Character, Integer> keyToNum = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    if (!keyToNum.containsKey(grid[i].charAt(j))) {
                        int idx = keyToNum.size();
                        keyToNum.put(grid[i].charAt(j), idx);
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<int[]>();
        int[][][] dist = new int[m][n][1 << keyToNum.size()];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        q.offer(new int[]{startX, startY, 0});
        dist[startX][startY][0] = 0;
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] arr = q.poll();
                int x = arr[0], y = arr[1], mask = arr[2];
                for (int[] dir: directions) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX].charAt(nextY) != '#') {
                        // 空房间和起点可以重复走
                        if (grid[nextX].charAt(nextY) == '.' || grid[nextX].charAt(nextY) == '@') {
                            if (dist[nextX][nextY][mask] == -1) {
                                dist[nextX][nextY][mask] = step + 1;
                                q.offer(new int[]{nextX, nextY, mask});
                            }
                        } else if (Character.isLowerCase(grid[nextX].charAt(nextY))) {
                            // 遇到了钥匙
                            int idx = keyToNum.get(grid[nextX].charAt(nextY));
                            if (dist[nextX][nextY][mask | (1 << idx)] == -1) {
                                // 之前没捡起来
                                dist[nextX][nextY][mask | (1 << idx)] = step + 1;
                                // 所有钥匙都遇到了
                                if ((mask | (1 << idx)) == (1 << keyToNum.size()) - 1) {
                                    return dist[nextX][nextY][mask | (1 << idx)];
                                }
                                q.offer(new int[]{nextX, nextY, mask | (1 << idx)});
                            }
                        } else {
                            // 第几把锁
                            int idx = keyToNum.get(Character.toLowerCase(grid[nextX].charAt(nextY)));
                            // 拿到了对应的钥匙，而且之前没来过
                            if((mask & (1 << idx)) != 0 && dist[nextX][nextY][mask] == -1) {
                                dist[nextX][nextY][mask] = step + 1;
                                q.offer(new int[]{nextX, nextY, mask});
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
