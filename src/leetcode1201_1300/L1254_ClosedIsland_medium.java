package leetcode1201_1300;

public class L1254_ClosedIsland_medium {
    // https://leetcode.cn/problems/number-of-closed-islands/?envType=study-plan-v2&envId=graph-theory
    private int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean ret1 = dfs(x - 1, y, grid);
        boolean ret2 = dfs(x + 1, y, grid);
        boolean ret3 = dfs(x, y - 1, grid);
        boolean ret4 = dfs(x, y + 1, grid);
        return ret1 && ret2 && ret3 && ret4;
    }
}
