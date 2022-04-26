package leetcode801_900;

public class Problem883 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        //x-y：每一个z不等于0的格子数
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] != 0) ans++;
            }
        }
        //x-z：每一行的最大值之和
        for (int i = 0 ; i < n ; i++) {
            int m = 0;
            for (int j = 0 ; j < n ; j++) {
                m = Math.max(m, grid[i][j]);
            }
            ans += m;
        }
        //y-z：每一列的最大值之和
        for (int i = 0 ; i < n ; i++) {
            int m = 0;
            for (int j = 0 ; j < n ; j++) {
                m = Math.max(m, grid[j][i]);
            }
            ans += m;
        }
        return ans;
    }

    public int projectionArea2(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        //x-y：每一个z不等于0的格子数
        //x-z：每一行的最大值之和
        //y-z：每一列的最大值之和
        for (int i = 0 ; i < n ; i++) {
            int rowMax = 0, colMax = 0;
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] != 0) ans++;
                rowMax = Math.max(rowMax, grid[i][j]);
                colMax = Math.max(colMax, grid[j][i]);
            }
            ans += rowMax + colMax;
        }
        return ans;
    }
}
