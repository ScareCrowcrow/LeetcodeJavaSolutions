package leetcode301_400;

public class L371_SumOfTwoIntegers_medium {
    // https://leetcode-cn.com/problems/sum-of-two-integers/
    public int getSum(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
