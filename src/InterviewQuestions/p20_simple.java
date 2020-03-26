package InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p20_simple {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return new int[0];
        int size = matrix.length * matrix[0].length;
        int[] res = new int[size];
        int index = 0;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (bottom >= top && right >= left){
            // left->right
            for (int i = left; i <= right; i++){
                res[index] = matrix[top][i];
                index++;
            }
            if (index == size) break;
            top++;
            // top->bottom
            for (int i = top; i <= bottom; i++){
                res[index] = matrix[i][right];
                index++;
            }
            if (index == size) break;
            right--;
            // right->left
            for (int i = right; i >= left; i--){
                res[index] = matrix[bottom][i];
                index++;
            }
            if (index == size) break;
            bottom--;
            // bottom->top
            for (int i = bottom; i >= top; i--){
                res[index] = matrix[i][left];
                index++;
            }
            if (index == size) break;
            left++;
        }
        return res;
    }
}
