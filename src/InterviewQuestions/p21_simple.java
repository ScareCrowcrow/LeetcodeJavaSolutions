package InterviewQuestions;

import java.util.Arrays;

public class p21_simple {
    public static int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] % 2 == 1){
                left++;
                continue;
            }
            if (nums[right] % 2 == 0){
                right--;
                continue;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {11,9,3,7,16,4,2,0};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
