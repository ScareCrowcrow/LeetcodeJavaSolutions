package p1_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L0054_medium {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return res;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        while (bottom >= top && right >= left){
            // left->right
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            if (res.size() == size) break;
            top++;
            // top->bottom
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            if (res.size() == size) break;
            right--;
            // right->left
            for (int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            if (res.size() == size) break;
            bottom--;
            // bottom->top
            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            if (res.size() == size) break;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res.toString());
    }
}
