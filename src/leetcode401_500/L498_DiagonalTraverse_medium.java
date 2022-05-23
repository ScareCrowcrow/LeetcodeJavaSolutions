package leetcode401_500;

public class L498_DiagonalTraverse_medium {
    // https://leetcode.cn/problems/diagonal-traverse/
    private int[] ans = null;
    private int size = 0;

    public int[] findDiagonalOrder(int[][] matrix) {
        ans = new int[matrix.length * matrix[0].length];
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        return ans;
    }

    public void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                ans[size++] = m[tR++][tC--];
            }
        } else {
            while (dR != tR - 1) {
                ans[size++] = m[dR--][dC++];
            }
        }
    }
}
