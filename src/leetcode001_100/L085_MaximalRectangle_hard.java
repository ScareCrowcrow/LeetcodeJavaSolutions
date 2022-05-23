package leetcode001_100;

import java.util.Stack;

public class L085_MaximalRectangle_hard {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        // 初始化最大面积max为0
        int n = heights.length, max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++){
            // 如果当前高度比堆栈顶端所记录的高度矮，开始对堆栈顶端记录的高度计算面积
            while(!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();

                max = Math.max(max, width * height);
            }
            // 如果当前的高度比堆栈顶端所记录的高度要高，则压入堆栈
            stack.push(i);
        }
        return max;
    }
}
