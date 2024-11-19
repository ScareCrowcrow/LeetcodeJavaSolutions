package leetcode1001_1100;

public class L1020_NumEnclaves_medium {
    // https://leetcode.cn/problems/number-of-enclaves/?envType=study-plan-v2&envId=graph-theory
    final static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] visited;
    private int m, n;
    public int numEnclaves(int[][] grid) {
        // 从边界的陆地开始遍历，dfs最终没有访问到的陆地就是最终的结果
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n-1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if(grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m-1][j] == 1) {
                dfs(grid, m-1, j);
            }
        }
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir: dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
