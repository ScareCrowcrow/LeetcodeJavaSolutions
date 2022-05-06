package leetcode301_400;

public class L384_ShuffleAnArray_medium {
    // https://leetcode-cn.com/problems/shuffle-an-array/
    class Solution {
        private int[] origin;
        private int[] shuffle;
        private int N;

        public Solution(int[] nums) {
            origin = nums;
            N = nums.length;
            shuffle = new int[N];
            for (int i = 0; i < N; i++) {
                shuffle[i] = origin[i];
            }
        }

        public int[] reset() {
            return origin;
        }

        // 0...N-i shuffle操作后，交换random_i位置和N-i位置的数
        public int[] shuffle() {
            for (int i = N - 1; i >= 0; i--) {
                int r = (int) (Math.random() * (i + 1));
                int tmp = shuffle[r];
                shuffle[r] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }
}
