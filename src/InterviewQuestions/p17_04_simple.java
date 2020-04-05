package InterviewQuestions;

// 异或

public class p17_04_simple {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res = res ^ i ^ nums[i];
        }
        res ^= nums.length;
        return res;
    }
}
