package p1_100;

public class L0052_hard {
    private boolean check(int row, int col, int[] columns){
        for (int r = 0; r < row; r++){
            if (columns[r] == col || row - r == Math.abs(columns[r] - col)){
                return false;
            }
        }
        return true;
    }

    int count;

    public int totalNQueens(int n){
        count = 0;
        backtracking(n, 0, new int[n]);
        return count;
    }

    private void backtracking(int n, int row, int[] columns){
        // 是否在所有n行里都摆放好了皇后？
        if (row == n) {
            count++; // 找到了了新的摆放方法
            return;
        }
        // 尝试着将皇后放置在当前行中的每⼀一列列
        for (int col = 0; col < n; col++) {
            columns[row] = col;
            // 检查是否合法，如果合法就继续到下一行
            if (check(row, col, columns)) {
                backtracking(n, row + 1, columns);
            }
            // 如果不不合法，就不不要把皇后放在这列中（回溯）
            columns[row] = -1;
        }
    }
}
