package leetcode201_300;

public class Problem233 {
    /*
    * 数位dp
    * 最高位为1：(K-1)*(10^(K-2))
    * 最高位不为1：(K-1)*(first * 10^(K-2))
    * 假设n为13625，分段分别计算
    * 3626 ~ 13625
    * 627 ~ 3626
    * 28 ~ 627
    * 9 ~ 28
    * 1 ~ 9
    * 每次只计算一段的1，然后递归求更小的段
    * */
    public static int countDigitOne(int num) {
        if (num < 1) {
            return 0;
        }
        // num -> 13625
        // len = 5位数
        int len = getLenOfNum(num);
        if (len == 1) {
            return 1;
        }
        // num  13625
        // tmp1 10000
        //
        // num  7872328738273
        // tmp1 1000000000000
        int tmp1 = powerBaseOf10(len - 1);
        // num最高位 num / tmp1
        int first = num / tmp1;
        // 最高1 N % tmp1 + 1
        // 最高位first tmp1
        int firstOneNum = first == 1 ? num % tmp1 + 1 : tmp1;
        // 除去最高位之外，剩下1的数量
        // 最高位1 10(k-2次方) * (k-1) * 1
        // 最高位first 10(k-2次方) * (k-1) * first
        int otherOneNum = first * (len - 1) * (tmp1 / 10);
        return firstOneNum + otherOneNum + countDigitOne(num % tmp1);
    }

    public static int getLenOfNum(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    public static int powerBaseOf10(int base) {
        return (int) Math.pow(10, base);
    }
}
