package leetcode901_1000;

import java.util.Arrays;

public class Problem915 {
    public static int minIncrementForUnique(int[] A) {
        if (A.length < 2)
            return 0;
        Arrays.sort(A);
        int move = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                A[i] += 1;
                move++;
                i--;
            }
        }
        return move;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        int res = minIncrementForUnique(A);
        System.out.println(res);
    }
}
