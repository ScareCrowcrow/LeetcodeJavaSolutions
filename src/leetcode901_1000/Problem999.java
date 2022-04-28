package leetcode901_1000;

public class Problem999 {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        if (board.length != 8 || board[0].length !=8) return res;
        int row = board.length;
        int col = board[0].length;
        int rowIndex = 0;
        int colIndex = 0;
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'R'){
                    rowIndex = i;
                    colIndex = j;

                }
            }
        }
        // up
        for(int i = rowIndex; i >= 0; i--){
            if(board[i][colIndex] == '.') continue;
            if(board[i][colIndex] == 'B') break;
            if(board[i][colIndex] == 'p'){
                res += 1;
                break;
            }
        }
        // down
        for(int i = rowIndex; i < row; i++){
            if(board[i][colIndex] == '.') continue;
            if(board[i][colIndex] == 'B') break;
            if(board[i][colIndex] == 'p'){
                res += 1;
                break;
            }
        }
        // left
        for(int j = colIndex; j >= 0; j--){
            if(board[rowIndex][j] == '.') continue;
            if(board[rowIndex][j] == 'B') break;
            if(board[rowIndex][j] == 'p'){
                res += 1;
                break;
            }
        }
        // right
        for(int j = colIndex; j < col; j++){
            if(board[rowIndex][j] == '.') continue;
            if(board[rowIndex][j] == 'B') break;
            if(board[rowIndex][j] == 'p'){
                res += 1;
                break;
            }
        }
        return res;
    }
}
