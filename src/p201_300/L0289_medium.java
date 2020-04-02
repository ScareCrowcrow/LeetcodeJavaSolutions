package p201_300;

public class L0289_medium {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                res[i][j] = helper(board, i, j);
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = res[i][j];
            }
        }
    }

    public static int helper(int[][] board, int row, int col){
        int rows = board.length;
        int columns = board[0].length;
        int cur = board[row][col];
        int aliveCount = 0;
        if (row - 1 >= 0){
            aliveCount += board[row-1][col];
            if (col - 1 >= 0){
                aliveCount += board[row-1][col-1];
            }
            if (col + 1 <= columns - 1){
                aliveCount += board[row-1][col+1];
            }
        }

        if (col - 1 >= 0){
            aliveCount += board[row][col-1];
        }
        if (col + 1 <= columns - 1){
            aliveCount += board[row][col+1];
        }

        if (row + 1 <= rows - 1){
            aliveCount += board[row+1][col];
            if (col - 1 >= 0)
                aliveCount += board[row+1][col-1];
            if (col + 1 <= columns - 1)
                aliveCount += board[row+1][col+1];
        }

        if (cur == 1 && (aliveCount == 2 || aliveCount == 3))
            return 1;
        if (cur == 0 && aliveCount == 3)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[][] boards = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        gameOfLife(boards);
    }

}
