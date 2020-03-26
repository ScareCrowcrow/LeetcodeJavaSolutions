package InterviewQuestions;

public class p16_medium {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;
        // use -(n+1) to avoid MIN_VALUE case
        if (n < 0) return 1/(x*myPow(x, -(n+1)));
        double res = 1;
        while (n > 1){
            if (n % 2 == 1){
                res *= x;
            }
            x = x * x;
            n /= 2;
        }
        res *= x;
        return res;
    }
}
