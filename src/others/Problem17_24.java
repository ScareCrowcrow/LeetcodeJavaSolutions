package others;

public class Problem17_24 {
    /*
    * 预处理技巧，行累加后，可以看作最大累加和子数组问题
    * 时间复杂度为O(row^2 * col)
    * */
    public int[] getMaxMatrix(int[][] m) {
        int N = m.length;
        int M = m[0].length;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < N; i++) {
            int[] s = new int[M];
            for (int j = i; j < N; j++) {
                cur = 0;
                int begin = 0;
                for (int k = 0; k < M; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    if (max < cur) {
                        max = cur;
                        a = i;
                        b = begin;
                        c = j;
                        d = k;
                    }
                    if (cur < 0) {
                        cur = 0;
                        begin = k + 1;
                    }
                }
            }
        }
        return new int[] { a, b, c, d };
    }

    // 子矩阵最大累加和
    public int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        // O(N^2 * M)
        int N = m.length;
        int M = m[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            // i~j
            int[] s = new int[M];
            for (int j = i; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    s[k] += m[j][k];
                }
                max = Math.max(max, maxSubArray(s));
            }
        }
        return max;
    }

    public int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
