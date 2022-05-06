package leetcode101_200;

public class L200_NumberOfIslands_medium {
    // https://leetcode-cn.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    infect(grid, i, j);
                }
            }
        }
        return islands;
    }

    // 从(i, j)位置出发，把所有连成一片的'1'字符，变成2
    public static void infect(char[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 2;
        infect(grid, i - 1, j);
        infect(grid, i + 1,  j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}
