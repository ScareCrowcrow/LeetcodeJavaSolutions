package InterviewQuestions;

public class p10_09_medium {
    // https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
    public boolean searchMatrix(int[][] matrix, int K) {
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == K) {
                return true;
            } else if (matrix[row][col] > K) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
