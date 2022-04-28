package leetcode001_100;

public class Problem037 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        boolean tmp = solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int row, int col){
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        while (row < 9 && col < 9){
            if (board[row][col] == '.') break;
            if (col == 8){
                col = 0;
                row++;
            }else col++;
        }
        if (row >= 9) return true;
        int newRow = row + col / 8;
        int newCol = (col + 1) % 9;
        for (int num = 1; num <= 9; num++){
            if (isValid(board, row, col, num)){
                board[row][col] = (char)(num + '0');
                boolean result = solveSudokuHelper(board, newRow, newCol);
                if (result) return true;
                board[row][col] = '.'; // 回溯
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, int num){
        for (int i = 0; i < 9; i++){
            // check column and row
            if (board[row][i] == num + '0' || board[i][col] == num + '0') return false;
        }
        // check square
        int rowoff = (row / 3) * 3;
        int coloff = (col / 3) * 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[rowoff + i][coloff + j] == num + '0') return false;
            }
        }
        return true;
    }
}
