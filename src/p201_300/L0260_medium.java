package p201_300;

public class L0260_medium {
    public int[] singleNumber(int[] nums) {
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
        // 用作异或分段
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & onePosition) == onePosition) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }

        return new int[]{ans1 ^ 0, ans2 ^ 0};
    }
}
