package leetcode1801_1900;

public class L1823_FindWinnerOfTheCircularGame_medium {
    // https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
    // 约瑟夫环问题
    public int findTheWinner(int n, int k) {
        return getLive(n, k);
    }

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
}
