package leetcode301_400;

public class Problem307 {
    // 一维IndexTree
    public class NumArray {
        // IndexTree
        private int[] tree;
        private int[] tmp;
        private int N;
        public NumArray(int[] nums) {
            if(nums == null || nums.length == 0) {
                return;
            }
            N = nums.length;
            tree = new int[N+1];
            tmp = new int[N];
            for(int i = 0; i < N; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int add = val - tmp[index];
            tmp[index] = val;
            for (int i = index + 1; i <= N; i += i & (-i)){
                tree[i] += add;
            }
        }

        public int sumRange(int left, int right) {
            return sum(right+1) - sum(left);
        }

        // 1~index 累加和是多少？
        private int sum(int index) {
            int ret = 0;
            while (index > 0) {
                ret += tree[index];
                index -= index & -index;
            }
            return ret;
        }
    }
}
