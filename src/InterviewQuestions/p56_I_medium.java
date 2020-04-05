package InterviewQuestions;

public class p56_I_medium {
    public int[] singleNumbers(int[] nums) {
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
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
