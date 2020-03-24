package p1_100;

public class L0048_medium {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int top = 0;
        int left = 0;
        int right = matrix.length - 1;
        int bottom = matrix.length - 1;
        int n = matrix.length;
        while (n > 1){
            for (int i = 0; i < n - 1; i++){
                int tmp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = tmp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n -= 2;
        }
    }
}
