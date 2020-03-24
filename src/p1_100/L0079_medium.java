package p1_100;

// TAG: 回溯

public class L0079_medium {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (existHelper(board, used, word.toCharArray(), 0, col, row)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, boolean[][] used, char[] word, int idx, int col, int row){
        if (idx == word.length) return true;
        // out of bound
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        if (used[row][col] == true || board[row][col] != word[idx]) return false;
        used[row][col] = true;
        // right
        boolean exist = existHelper(board, used, word, idx+1, col+1, row);
        if (exist) return true;
        // left
        exist = existHelper(board, used, word, idx+1, col-1, row);
        if (exist) return true;
        // up
        exist = existHelper(board, used, word, idx+1, col, row+1);
        if (exist) return true;
        // down
        exist = existHelper(board, used, word, idx+1, col, row-1);
        if (exist) return true;
        // 回溯
        used[row][col] = false;
        return false;
    }
}
