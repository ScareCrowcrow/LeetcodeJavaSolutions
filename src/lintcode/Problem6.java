package lintcode;

public class Problem6 {
    // https://www.lintcode.com/problem/6/description
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return null;
        }
        int[] ans = new int[A.length + B.length];
        int i = 0, j = 0, index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                ans[index++] = A[i++];
            } else {
                ans[index++] = B[j++];
            }
        }
        while (i < A.length) {
            ans[index++] = A[i++];
        }
        while (j < B.length) {
            ans[index++] = B[j++];
        }
        return ans;
    }
}
