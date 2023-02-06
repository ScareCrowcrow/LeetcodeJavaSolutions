package leetcode601_700;

public class L633_SumOfSquareNumbers_medium {
    // https://leetcode.cn/problems/sum-of-square-numbers/
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}
