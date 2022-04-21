package leetcode1901_2000;

public class Problem1908 {
    // Nim博弈
    public boolean nimGame(int[] piles) {
        int eor = 0;
        for (int num : piles) {
            eor ^= num;
        }
        return eor != 0;
    }
}
