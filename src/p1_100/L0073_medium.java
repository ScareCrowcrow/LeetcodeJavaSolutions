package p1_100;

// 思路：将flag字段存储在第一行和第一列, 需要特殊处理原本的第一行和第一列

public class L0073_medium {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        for (int x = 1; x < matrix[0].length; x++){
            for (int y = 1; y < matrix.length; y++){
                if (matrix[y][x] == 0){
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for (int j = 1; j < matrix.length; j++) matrix[j][i] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < matrix[0].length; j++) matrix[i][j] = 0;
            }
        }
        if (firstRowZero) for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        if (firstColZero) for (int j = 0; j < matrix.length; j++) matrix[j][0] = 0;
    }
}
