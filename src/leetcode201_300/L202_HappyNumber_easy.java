package leetcode201_300;

import java.util.HashSet;

public class L202_HappyNumber_easy {
    // https://leetcode-cn.com/problems/happy-number/
    public static boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int r = n % 10;
                sum += r * r;
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) {
                break;
            }
            set.add(n);
        }
        return n == 1;
    }

    // 不是快乐数最终一定会到4，然后循环
    public static boolean isHappy2(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
