package InterviewQuestions;

public class Problem10_09 {
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
