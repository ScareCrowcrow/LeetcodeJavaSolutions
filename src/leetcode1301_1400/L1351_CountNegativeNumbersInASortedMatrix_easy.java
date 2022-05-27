package leetcode1301_1400;

public class L1351_CountNegativeNumbersInASortedMatrix_easy {
    // https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
    public int countNegatives(int[][] grid) {
        int res = 0;
        int row = 0, col = grid[0].length - 1;
        // 从最右上角开始
        while (row < grid.length && col > -1) {
            if (grid[row][col] < 0) {
                res += grid.length - row;
                // 向左移动
                col--;
            } else {
                // 向下移动
                row++;
            }
        }
        return res;
    }
}
