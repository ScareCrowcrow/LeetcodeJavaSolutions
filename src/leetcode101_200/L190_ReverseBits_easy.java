package leetcode101_200;

public class L190_ReverseBits_easy {
    // https://leetcode-cn.com/problems/reverse-bits/
    public static int reverseBits(int n) {
        // n的高16位，和n的低16位，交换
        n = (n >>> 16) | (n << 16);
        // 前后16位的高8位分别移到低8位     前后16位的低8位分别移到高8位
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
