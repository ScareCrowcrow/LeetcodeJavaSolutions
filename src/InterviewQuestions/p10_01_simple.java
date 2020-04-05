package InterviewQuestions;

import java.util.Arrays;

public class p10_01_simple {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++){
            if (B[i] != 0){
                A[m+i] = B[i];
            }
        }
        Arrays.sort(A);
    }
}
