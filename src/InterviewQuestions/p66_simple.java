package InterviewQuestions;

// 思路：对称遍历
// B[i]可以看做A[i]前面的元素的乘积和A[i]后面元素的乘积
// 正向遍历获得A[i]前面元素的乘积,反向补偿A[i]后面的乘积

public class p66_simple {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        if (a.length == 1) return a;
        int[] b = new int[a.length];
        int left = 1;
        for (int i = 0; i < a.length; i ++) {
            b[i] = left;
            left = left * a[i];
        }
        int right = 1;
        for (int i = a.length-1; i >= 0; i--) {
            b[i] *= right;
            right *= a[i];
        }
        return b;
    }

}
