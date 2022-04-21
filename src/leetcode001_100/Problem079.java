package leetcode001_100;

public class Problem079 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) {
            return true;
        }
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (process(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从m[i][j]这个字符出发，能不能找到w[k...]这个后缀串
    public boolean process(char[][] m, int i, int j, char[] str, int k) {
        if (k == str.length) {
            return true;
        }
        if (i == -1 || i == m.length || j == -1 || j == m[0].length || m[i][j] == 0 || m[i][j] != str[k]) {
            return false;
        }
        m[i][j] = 0;
        boolean ans = false;
        if (process(m, i + 1, j, str, k + 1) || process(m, i - 1, j, str, k + 1) || process(m, i, j + 1, str, k + 1)
                || process(m, i, j - 1, str, k + 1)) {
            ans = true;
        }
        m[i][j] = str[k];
        return ans;
    }
}
