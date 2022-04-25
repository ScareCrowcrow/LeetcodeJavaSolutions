package others;

public class ProblemOffer62 {
    // 约瑟夫环问题
    // 给定的编号是0~n-1的情况下，数到m就杀
    // 返回谁会活？
    public int lastRemaining1(int n, int m) {
        return getLive(n, m) - 1;
    }

    // 课上题目的设定是，给定的编号是1~n的情况下，数到m就杀
    // 返回谁会活？
    public static int getLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        // 剃刀函数
        // 前 = (后 - 1 + s) % i + 1
        // s = (m - 1) % i + 1
        // 前 = (后 + m - 1) % i + 1
        return (getLive(n - 1, m) + m - 1) % n + 1;
    }

    // 给定的编号是0~n-1的情况下，数到m就杀
    // 返回谁会活？
    // 这个版本是迭代版
    public int lastRemaining2(int n, int m) {
        int ans = 1;
        int r = 1;
        while (r <= n) {
            ans = (ans + m - 1) % (r++) + 1;
        }
        return ans - 1;
    }
}
